package model;

public class Edge
{
    private Node n1;
    private Node n2;
    private int weight;


    public Edge(Node n1, Node n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = calcWeight(n1, n2);
    }
    public void setWeight(int weight) {
        this.weight = weight;
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

    public boolean hasNode(Node node){return node==n1 || node ==n2;}

    private int calcWeight(Node n1, Node n2) {
        return (int) (Math.sqrt(Math.pow(n1.getX() - n2.getX(), 2)) + Math.pow(n1.getY() - n2.getY(), 2));
    }

}
