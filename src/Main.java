import control.Dijkstra;
import model.Graph;
import model.Edge;
import model.Node;
import view.MainWindow;

import javax.swing.*;
import java.awt.*;


public class Main
{


    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

        //generate example graph just for testing purpose
        Graph g = generateGraph();

        //Initialize Djikstra instance
        Dijkstra dijkstraAlgo = new Dijkstra(g);

        //solve for given graph
        dijkstraAlgo.solveDijkstraAlgorithm();


        //SwingUtilities.invokeLater(MainWindow::new);

    }


    //ToDo TestGraph
    public static Graph generateGraph()
    {
        Graph graph = new Graph();

        Point n1 = new Point(3,1);
        Point n2 = new Point(12,4);
        Point n3 = new Point(6,5);

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);


        Edge e1 = new Edge(graph.getNode(0), graph.getNode(1));
        Edge e2 = new Edge(graph.getNode(1), graph.getNode(2));

        graph.addEdge(e1);
        graph.addEdge(e2);

        graph.setEnd(graph.getNode(graph.getSize()-1));

        return graph;
    }

}
