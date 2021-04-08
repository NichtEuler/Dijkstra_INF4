import control.Dijkstra;
import model.Graph;
import model.Edge;
import model.Node;
import view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Main {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e);
        }

        //generate example graph just for testing purpose
        Graph graph = new Graph();
        graph.generateGraph();

        //Initialize Dijkstra instance
        Dijkstra dijkstraAlgo = new Dijkstra(graph);

        //solve for given graph
        dijkstraAlgo.getShortestPath();
        System.out.println(graph.getSolvedPath());

        SwingUtilities.invokeLater(() -> new MainWindow(graph));
    }
}
