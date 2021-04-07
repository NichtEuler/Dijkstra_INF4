import control.Dijkstra;
import model.Graph;
import model.Edge;
import model.Node;
import view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e);
        }

        //generate example graph just for testing purpose
        Graph g = generateGraph();

        //Initialize Djikstra instance
        Dijkstra dijkstraAlgo = new Dijkstra(g);

        //solve for given graph
        ArrayList<Node> shortestPath = dijkstraAlgo.getShortestPath();
        System.out.println(shortestPath);

        SwingUtilities.invokeLater(() -> new MainWindow(g));

    }


    //ToDo TestGraph
    public static Graph generateGraph() {
        Graph graph = new Graph();

        for (int i = 0; i < 10; i++) {
            int randomNumX = ThreadLocalRandom.current().nextInt(100, 1400 + 1);
            int randomNumY = ThreadLocalRandom.current().nextInt(100, 800 + 1);

            Point p = new Point(randomNumX, randomNumY);
            graph.addNode(p);
        }

        for (int i = 0; i < graph.getSize() * 2; i++) {
            int randNode1 = ThreadLocalRandom.current().nextInt(1, graph.getSize() - 1);
            int randNode2 = ThreadLocalRandom.current().nextInt(1, graph.getSize() - 1);
            graph.addEdge(new Edge(graph.getNode(randNode1), graph.getNode(randNode2)));
        }
        //TODO generierte Knoten und kanten automatisch anzeichnen

//        Point n1 = new Point(3, 1);
//        Point n2 = new Point(12, 4);
//        Point n3 = new Point(6, 5);
//
//        graph.addNode(n1);
//        graph.addNode(n2);
//        graph.addNode(n3);
//
//
//        Edge e1 = new Edge(graph.getNode(0), graph.getNode(1));
//        Edge e2 = new Edge(graph.getNode(1), graph.getNode(2));
//
//        graph.addEdge(e1);
//        graph.addEdge(e2);

        graph.setEnd(graph.getNode(graph.getSize() - 1));

        return graph;
    }

}
