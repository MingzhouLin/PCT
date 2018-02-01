package tree.normal;

import java.util.LinkedList;

public class Node {
    public int value;
    public String name;
    public LinkedList<Node> subNodes = new LinkedList<>();
    public Node parent;

    public void addSubNode(Node node){
        subNodes.add(node);
        node.parent = this;
    }
}
