package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private Node start;
    private Node end;
    private int counter = 1;

    private List<Node> nodeList = new ArrayList<>();
    private List<Edge> edgeList = new ArrayList<>();

    public void addNode(Point p) {
        Node node = new Node(p);
        addNode(node);
    }

    private void addNode(Node node) {
        node.setId(counter++);
        nodeList.add(node);
    }

    public void setEdge(Edge edge) {

        //TODO schauen ob nodes unterschiedlich sind dann edgelist.add
        edgeList.add(edge);
    }
}
