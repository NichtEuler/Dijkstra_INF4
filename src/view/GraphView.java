package view;

import model.Edge;
import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;

public class GraphView extends JPanel {
    private Graph graph;
    private Graphics2D g2;
    private int radius = 50;

    public GraphView(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (Node node :
                graph.getNodeList()) {
            g.setColor(Color.red);
            g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);



        }

        for (Edge edge :
                graph.getEdgeList()) {
            Point from = edge.getNode1().getCoord();
            Point to = edge.getNode2().getCoord();
            g2.setStroke(new BasicStroke(8));
            g.drawLine(from.x, from.y, to.x, to.y);
            int x = (from.x + to.x)/2;
            int y = (from.y + to.y)/2;

        }
    }
    public static Color parseColor(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
}
