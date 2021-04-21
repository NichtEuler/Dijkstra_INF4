package control;

import model.Edge;
import model.Graph;
import model.Node;

import java.util.*;

public class Dijkstra {

    public Dijkstra(Graph g) {
        this.graph = g;
        this.distance = new HashMap<Node, Integer>();
        this.predecessor = new HashMap<Node, Node>();
    }


    //TODO algorithmus implementieren
    //visitednodes
    //vorgänger
    //unvisitedNodes adds reachable from current node
    //currentnode
    //Vorgehen wikipedia
    //Weise allen Knoten die beiden Eigenschaften (Attribute) „Distanz“ und „Vorgänger“ zu. Initialisiere die Distanz im Startknoten mit 0 und in allen anderen Knoten mit {\displaystyle \infty }\infty .
    //Solange es noch unbesuchte Knoten gibt, wähle darunter denjenigen mit minimaler (aufsummierte) Distanz aus und
    //Speichere, dass dieser Knoten schon besucht wurde.
    //Berechne für alle noch unbesuchten Nachbarknoten die Gesamtdistanz über die Summe des jeweiligen Kantengewichtes und der bereits berechneten Distanz vom Startknoten zum aktuellen Knoten.
    //Ist dieser Wert für einen Knoten kleiner als die dort gespeicherte Distanz, aktualisiere sie und setze den aktuellen Knoten als Vorgänger.
    //Dieser Schritt wird auch als Update oder Relaxation/Relaxierung bezeichnet.


    private Graph graph;
    private List<Node> Q; //same as wikipedia syntax --> all nodes from the graph
    private HashMap<Node, Integer> distance; //HashMaps<Key, Wert> speichern zu einem Key keinen oder genau einen Wert. Abfrage des wertes hier distance.get(key)
    private HashMap<Node, Node> predecessor;

    //private HashSet, TreeSet, LinkedHashSet<Node> visited;
    //(https://stackoverflow.com/questions/13259535/how-to-maintain-a-unique-list-in-java)
    //HashSet is universal and fast, treeset is ordered,LinkedHashset keeps insertion order -> HashSet?

    //private HashSet<Node> unvisited; dann zu jeder node in unvisited mit aktueller die distanz vergleichen, die kürzeste distanz nehmen und node löschen

    //Initialisierung hashMap distance
    //  for (Node n : graph.getNodeList()) {
    //      distance.put(n, Integer.MAX_VALUE);
    //      }


    public void getShortestPath() {
        ArrayList<Node> shortestPath = new ArrayList<Node>();
        this.solveDijkstraAlgorithm();

        shortestPath.add(this.graph.getEnd());

        Node u = this.graph.getEnd();
        // Der Vorgänger des Startknotens ist null
        while (this.predecessor.get(u) != null) {
            u = this.predecessor.get(u);
            shortestPath.add(0, u);
        }
        if(u == graph.getStart()) { // check if the last node == startnode
            graph.setSolvedPath(shortestPath);
        }
    }

    private void solveDijkstraAlgorithm() {
        //Steps see wiki:

        //Step 1: Iniitalization
        this.initialize();

        //The "actual" algorithm
        while (this.Q.size() != 0) {
            //get node from Q with smalltest value in distance
            //Map.Entry<Node, Integer> minDistance = Collections.min(this.distance.entrySet(),
            //        Comparator.comparing(Map.Entry::getValue));
            //Node u = minDistance.getKey();
            int dist = Integer.MAX_VALUE;
            Node u = Q.get(0);
            for (Node e : Q) {
                if (this.distance.get(e) < dist) {
                    dist = this.distance.get(e);
                    u = e;
                }
            }


            //remove u from Q
            this.Q.remove(u); // für u ist der kürzeste Weg nun bestimmt

            //find all neighbors v of u
            List<Edge> V = this.graph.getNeighbours(u);
            for (Edge edgeBetweenUandV : V) {
                Node v = edgeBetweenUandV.getSecondNode(u);
                if (Q.contains(v))  // falls noch nicht berechnet
                {
                    distance_update(u, v, edgeBetweenUandV);
                }
            }

        }
    }


    private void initialize() {
        int numberOfNodes = this.graph.getSize();
        for (int i = 0; i < numberOfNodes; i++) {
            Node currentNode = this.graph.getNode(i);
            this.distance.put(currentNode, Integer.MAX_VALUE);
            this.predecessor.put(currentNode, null);
        }
        this.distance.put(this.graph.getStart(), 0);
        this.Q = new ArrayList<Node>(this.graph.getNodeList()); //to not delete nodes from original graph
    }


    private void distance_update(Node u, Node v, Edge e) {
        // Weglänge vom Startknoten nach v über u
        int alternativeDistance = this.distance.get(u) + e.getWeight();
        if (alternativeDistance < this.distance.get(v)) {
            this.distance.put(v, alternativeDistance);
            this.predecessor.put(v, u);
        }
    }


}
