package control;

import model.Edge;
import model.Graph;
import model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {

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
    private HashMap<Node, Integer> distance; //HashMaps<Key, Wert> speichern zu einem Key keinen oder genau einen Wert. Abfrage des wertes hier distance.get(key)
    private HashMap<Node, Node> vorgaenger; //TODO übersetzung

    //private HashSet, TreeSet, LinkedHashSet<Node> visited;
    //(https://stackoverflow.com/questions/13259535/how-to-maintain-a-unique-list-in-java)
    //HashSet is universal and fast, treeset is ordered,LinkedHashset keeps insertion order -> HashSet?

    //private HashSet<Node> unvisited; dann zu jeder node in unvisited mit aktueller die distanz vergleichen, die kürzeste distanz nehmen und node löschen

    //Initialisierung hashMap distance
    //  for (Node n : graph.getNodeList()) {
    //      distance.put(n, Integer.MAX_VALUE);
    //      }


    public List<Edge> getNeighbours(Node node) {
        List<Edge> neighbours = new ArrayList<>();
        for (Edge edge : graph.getEdgeList()) {
            if (edge.hasNode(node)) {
                neighbours.add(edge);
            }

        }
        return neighbours;
    }

}
