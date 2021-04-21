package view;

import model.Edge;
import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphView extends JPanel {
    private Graph graph;
    private Graphics2D g2;
    private int radius = 20;

    public GraphView(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(Color.WHITE);

        for (Edge edge :
                graph.getEdgeList()) {
            paintEdge(edge, Color.BLACK);
        }

        for (Node node :
                graph.getNodeList()) {
            paintNode(node, Color.BLUE);
        }
        paintSolvedPath();

        drawStartNode(graph.getStart());
        drawEndNode(graph.getEnd());
    }

    public void repaintTest() {
        g2.setBackground(Color.cyan);
    }

    private void paintSolvedPath() {
        List<Edge> edgePath = new ArrayList<Edge>();

        for (int i = 0; i < graph.getSolvedPath().size() - 1; i++) {
            Edge edge = graph.getEdge(graph.getSolvedPath().get(i), graph.getSolvedPath().get(i + 1));
            edgePath.add(edge);
        }

        for (Edge edge :
                edgePath) {
            paintSolvedPath(edge);
        }

        for (Node node :
                graph.getSolvedPath()) {
            paintNode(node, Color.magenta);
        }
    }

    private void drawEndNode(Node end) {
        paintNode(end, Color.GREEN);
    }

    private void drawStartNode(Node start) {
        paintNode(start, Color.BLACK);
    }

    private void paintNode(Node node, Color color) {
        g2.setColor(color);
        g2.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);
    }

    private void paintEdge(Edge edge, Color color) {
        Point from = edge.getNode1().getCoord();
        Point to = edge.getNode2().getCoord();

        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(from.x, from.y, to.x, to.y);

        drawWeight(from, to, edge.getWeight());
    }

    private void drawWeight(Point from, Point to, int weight) {

        int x = (from.x + to.x) / 2;
        int y = (from.y + to.y) / 2;

        g2.setColor(Color.ORANGE);
        g2.fillOval(x - radius / 2, y - radius / 2, radius, radius);
        g2.setColor(Color.BLACK);

        FontMetrics fm = g2.getFontMetrics();
        double t_width = fm.getStringBounds(String.valueOf(weight), g2).getWidth();
        g2.drawString(String.valueOf(weight), (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }

    private void paintSolvedPath(Edge edge) {
        paintEdge(edge, Color.CYAN);
    }
}
