package model;
public class Edge {

    private Node n1;
    private Node n2;
    private int weight = 1;

    public Edge(Node n1, Node n2) {
        this.n1 = n1;
        this.n2 = n2;
        setWeight();
    }

    public void setWeight() {

        double weight = Math.sqrt(Math.pow(n1.getX() - n2.getX(), 2) + Math.pow(n1.getY() - n2.getY(), 2));
        this.weight = (int) Math.ceil(weight / 100);
    }

    public int getWeight() {
        return weight;
    }

    public Node getNode1() {
        return n1;
    }

    public Node getNode2() {
        return n2;
    }

    public Node getSecondNode(Node n1_in) {
        if (this.n1 == n1_in) return this.n2;
        else return this.n1;
    }

    public boolean hasNode(Node node) {
        return node == n1 || node == n2;
    }
}
