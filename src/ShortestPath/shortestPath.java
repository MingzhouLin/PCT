package ShortestPath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.sampled.spi.AudioFileReader;



public class shortestPath {
	public static void main(String args[]) {
		new shortestPath().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		Graph graph=new Graph();
		for (int i = 0; i < N; i++) {
			String first=scanner.next();
			if (graph.nodes.containsKey(first)) {
				String second=scanner.next();
				if (graph.nodes.containsKey(second)) {
					Edge edge=new Edge();
					edge.from=graph.nodes.get(first);
					edge.to=graph.nodes.get(second);
					edge.weighted=scanner.nextInt();
					graph.nodes.get(first).adj.add(edge);
				}else {
					Node node1=new Node();
					node1.name=second;
					graph.nodes.put(second, node1);
					Edge edge=new Edge();
					edge.from=graph.nodes.get(first);
					edge.to=node1;
					edge.weighted=scanner.nextInt();
					graph.nodes.get(first).adj.add(edge);
				}
			}else {
				Node node=new Node();
				node.name=first;
				graph.nodes.put(first, node);
				String second=scanner.next();
				if (graph.nodes.containsKey(second)) {
					Edge edge=new Edge();
					edge.from=node;
					edge.to=graph.nodes.get(second);
					edge.weighted=scanner.nextInt();
					graph.nodes.get(first).adj.add(edge);
				}else {
					Node node1=new Node();
					node1.name=second;
					graph.nodes.put(second, node1);
					Edge edge=new Edge();
					edge.from=graph.nodes.get(first);
					edge.to=node1;
					edge.weighted=scanner.nextInt();
					graph.nodes.get(first).adj.add(edge);
				}
			}
		}
//		graph.graphPrint();
		String source=scanner.next();
		HashMap<Node, Path> shortestPath=new HashMap<>();
		LinkedList<Node> addedNode=new LinkedList<>();
		Path Source=new Path();
		Source.weighted=0;
		Source.last=graph.nodes.get(source);
		shortestPath.put(graph.nodes.get(source), Source);
		addedNode.add(graph.nodes.get(source));
		for (Edge edge : graph.nodes.get(source).adj) {
			Path target=new Path();
			target.weighted=edge.weighted;
			target.last=graph.nodes.get(source);
			shortestPath.put(edge.to,target);
		}
		for (Node node : graph.nodes.values()) {
			if (!shortestPath.containsKey(node)) {
				Path target=new Path();
				target.weighted=10000;
				target.last=graph.nodes.get(source);
				shortestPath.put(node,target);
			}
		}
		
		while (addedNode.size()<graph.nodes.size()) {
			int min=100000;
			Node newNode=new Node();
			for (HashMap.Entry<Node,Path> entry : shortestPath.entrySet()) {
				if (entry.getValue().weighted<min&&!addedNode.contains(entry.getKey())) {
					min=entry.getValue().weighted;
					newNode=entry.getKey();
				}
			}
			addedNode.add(newNode);
			for (Edge edge : graph.nodes.get(newNode.name).adj) {
				if (edge.weighted+shortestPath.get(newNode).weighted<shortestPath.get(edge.to).weighted) {
					shortestPath.get(edge.to).weighted=edge.weighted+shortestPath.get(newNode).weighted;
					shortestPath.get(edge.to).last=edge.from;
				}
			}
		}
		
		System.out.println(shortestPath.get(graph.nodes.get("A")).weighted);
		Node last=shortestPath.get(graph.nodes.get("A")).last;
		System.out.print("A<-");
		while (!last.name.equals("F")) {
			System.out.print(last.name+"<-");
			last=shortestPath.get(graph.nodes.get(last.name)).last;
		}
		System.out.print("F");
	}
}

class Path{
	int weighted;
	Node last;
}

class Graph{
	HashMap<String, Node> nodes=new HashMap<>();
	public void graphPrint() {
		for (HashMap.Entry<String,Node> entry : nodes.entrySet()) {
			System.out.print(entry.getValue().name+":");
			for (Edge edge : entry.getValue().adj) {
				System.out.print(edge.from.name+"->"+edge.to.name+":"+edge.weighted);
			}
			System.out.println();
		}
	}
}

class Node{
	LinkedList<Edge> adj=new LinkedList<>();
	String name;
//	public void addNode(Node node) {
//		
//	}
}

class Edge{
	Node from;
	Node to;
	int weighted;
}