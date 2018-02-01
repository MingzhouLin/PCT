package graph.unweighted;

import java.util.LinkedList;

public class Node {
    public int value;
    public String name;
    public LinkedList<Node> nodes = new LinkedList<>();

    public void addNode(Node node, boolean reverse) {
        nodes.add(node);

        // if is undirected graph
        if (reverse) {
            node.addNode(this, false);
        }
    }
}
