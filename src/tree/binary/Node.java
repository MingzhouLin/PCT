package tree.binary;

import java.util.LinkedList;

public class Node {
    public int value;
    public String name;
    public Node left;
    public Node right;
    public Node parent;

    public void setLeft(Node node){
        left = node;
        node.parent = this;
    }

    public void setRight(Node node){
        right = node;
        node.parent = this;
    }
}
