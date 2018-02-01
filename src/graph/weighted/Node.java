package graph.weighted;

import java.util.LinkedList;

public class Node {
    public int value;
    public String name;

    public LinkedList<Edge> edges = new LinkedList<>();

    public void addNode(Node node, int value, boolean reverse) {
        Edge edge = new Edge(this, node);
        edge.value = value;
        this.edges.add(edge);

        // if is undirected graph
        if (reverse) {
            node.addNode(this, value, false);
        }
    }
}
