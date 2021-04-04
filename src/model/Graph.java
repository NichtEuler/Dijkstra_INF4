package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph
{
    private Node start;
    private Node end;
    private int counter = 0;

    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();

    public void addNode(Point p)
    {
        Node node = new Node(p);
        addNode(node);
    }

    private void addNode(Node node)
    {
        node.setId(counter++);
        this.nodeList.add(node);
        if (counter == 1) {
            setStart(node);
        }

    }

    public int getSize()
    {
        return this.counter;
    }

    public Node getNode(int id)
    {
        return nodeList.get(id);
    }

    public void setStart(Node node) {
        if (getNodeList().contains(node)) {
            start = node;
        }
    }

    public void setEnd(Node node) {
        if (getNodeList().contains(node)) {
            end = node;
        }
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd()
    {
        return end;
    }

    public boolean isStart(Node node) {return node == start;}
    public boolean isEnd(Node node) {return node == end;}

    public void addEdge(Edge edge)
    {
        //TODO schauen ob nodes unterschiedlich sind dann edgelist.add
        if (!edge.getNode1().equals(edge.getNode2()))
        {
            this.edgeList.add(edge);
        }
    }


    public List<Edge> getNeighbours(Node node)
    {
        List<Edge> neighbours = new ArrayList<>();
        for (Edge edge : this.edgeList)
        {
            if (edge.hasNode(node))
            {
                neighbours.add(edge);
            }

        }
        return neighbours;
    }
}
