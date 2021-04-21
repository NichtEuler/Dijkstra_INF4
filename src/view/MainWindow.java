package view;

import control.Dijkstra;
import model.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

    public MainWindow(Graph graph) {
        JLabel label = new JLabel("  Push backspace for new graph; Push ESC to close window", JLabel.LEFT);
        JPanel graphView = new GraphView(graph);
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = gEnv.getDefaultScreenDevice();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    graph.resetGraph();
                    graph.generateGraph();
                    Dijkstra dijkstraAlgo = new Dijkstra(graph);
                    dijkstraAlgo.getShortestPath();
                    graphView.repaint();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        defaultScreen.setFullScreenWindow(this);
        setVisible(true);
        setLayout(new BorderLayout());
        add(graphView, BorderLayout.CENTER);
        add(label, BorderLayout.NORTH);
    }
}
