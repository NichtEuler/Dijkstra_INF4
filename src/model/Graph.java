package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    private Node start;
    private Node end;
    private int counter = 0;

    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();
    private List<Node> solvedPath = new ArrayList<Node>();

    public void resetGraph()
    {
        start = null;
        end = null;
        counter = 0;

        nodeList.removeAll(nodeList);
        edgeList.removeAll(edgeList);
        solvedPath.removeAll(solvedPath);
    }

    public void addNode(Point p) {
        Node node = new Node(p);
        addNode(node);
    }

    private void addNode(Node node) {
        node.setId(counter++);
        this.nodeList.add(node);
        if (counter == 1) {
            setStart(node);
        }

    }

    public int getSize() {
        return this.counter;
    }

    public Node getNode(int id) {
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

    public Node getEnd() {
        return end;
    }

    public List<Node> getSolvedPath() {
        return solvedPath;
    }

    public void setSolvedPath(List<Node> solvedPath) {
        this.solvedPath = solvedPath;
    }

    public boolean isStart(Node node) {
        return node == start;
    }

    public boolean isEnd(Node node) {
        return node == end;
    }

    public void addEdge(Edge edge) {
        if (!edge.getNode1().equals(edge.getNode2())) {
            this.edgeList.add(edge);
        }
    }

    public List<Edge> getNeighbours(Node node) {
        List<Edge> neighbours = new ArrayList<>();
        for (Edge edge : this.edgeList) {
            if (edge.hasNode(node)) {
                neighbours.add(edge);
            }
        }
        return neighbours;
    }

    public Edge getEdge(Node n1, Node n2) {
        for (Edge edge :
                this.edgeList) {
            if (edge.hasNode(n1) && edge.hasNode(n2)) {
                return edge;
            }
        }
        return null;
    }

    public void generateGraph() {
        //Sets starting point at fixed position
        this.addNode(new Point(50, 50));

        generateNodes();

        generateEdges();

        this.setEnd(this.getNode(this.getSize() - 1));
    }

    private void generateNodes() {
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < this.getNodeList().size(); j++) {
                int randomNumX = getRandomNumberUsingNextInt(100, 1400 + 1);
                int randomNumY = getRandomNumberUsingNextInt(100, 800 + 1);
                int boundX = this.getNodeList().get(j).getX();
                int boundY = this.getNodeList().get(j).getY();

                if (!((randomNumX <= boundX + 120 && randomNumX >= boundX - 120) &&
                        (randomNumY <= boundY + 120 && randomNumY >= boundY - 120))) {
                    Point p = new Point(randomNumX, randomNumY);
                    this.addNode(p);
                    break;
                } else {
                    if (i - 1 <= 0)
                        i = 0;
                    else
                        i--;
                }
            }
        }
    }

    private void generateEdges() {
        for (int i = 0; i < this.getSize() *1.2; i++) {
            int randNode1 = getRandomNumberUsingNextInt(0, this.getSize());
            int randNode2 = getRandomNumberUsingNextInt(0, this.getSize());
            Edge edge = new Edge(this.getNode(randNode1), this.getNode(randNode2));

            edge.setWeight(getRandomNumberUsingNextInt(1, 20));
            this.addEdge(edge);
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
