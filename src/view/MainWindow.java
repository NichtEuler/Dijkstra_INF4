package view;

import model.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

    private JLabel label;
    private Graph graph;

    public MainWindow(Graph graph) {
        this.graph = graph;
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = gEnv.getDefaultScreenDevice();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        defaultScreen.setFullScreenWindow(this);
        setVisible(true);

        setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();
        label = new JLabel("flag");
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 40));
        subPanel.add(label);
        add(subPanel, BorderLayout.CENTER);

        JPanel graphView = new GraphView(graph);
        add(graphView, BorderLayout.CENTER);


    }

}
