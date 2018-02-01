package graph.weighted;


public class Edge {
    public int value;

    public Node from;
    public Node to;

    public Edge() {
    }

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }
}
0 6 1 5 100000 100000
6 0 5 100000 3 100000
1 5 0 7 5 4
5 100000 7 0 100000 2
100000 3 5 100000 0 6
100000 100000 4 2 6 0