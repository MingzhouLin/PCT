package DeadLock;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class deadLock {
	public static void main(String args[]) {
		new deadLock().run();
	}
	
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		Graph graph=new Graph();
		for (int i = 0; i < N; i++) {
			if (i==0) {
				Node node=new Node();
				node.value=scanner.nextInt();
				graph.nodes.put(node.value, node);
				Node node1=new Node();
				node1.value=scanner.nextInt();
				if (node1.value!=-1) {
					node1.adj.add(node);
					graph.nodes.put(node1.value, node1);
				}
				node1=new Node();
				node1.value=scanner.nextInt();
				if (node1.value!=-1) {
					node.adj.add(node1);
					graph.nodes.put(node1.value, node1);
				}
				continue;
			}
			int next=scanner.nextInt();
			if (graph.nodes.containsKey(next)) {
				int second=scanner.nextInt();
				if (graph.nodes.containsKey(second)) {
					graph.nodes.get(second).adj.add(graph.nodes.get(next));
				}else {
					Node node1=new Node();
					node1.value=second;
					if (node1.value!=-1) {
						node1.adj.add(graph.nodes.get(next));
						graph.nodes.put(node1.value, node1);
					}
				}
				int third=scanner.nextInt();
				if (graph.nodes.containsKey(third)) {
					graph.nodes.get(next).adj.add(graph.nodes.get(third));
				}else {
					Node node1=new Node();
					node1.value=third;
					if (node1.value!=-1) {
						graph.nodes.get(next).adj.add(node1);
						graph.nodes.put(node1.value, node1);
					}
				}
			}else {
				Node node=new Node();
				node.value=next;
				graph.nodes.put(node.value, node);
				int second=scanner.nextInt();
				if (graph.nodes.containsKey(second)) {
					graph.nodes.get(second).adj.add(node);
				}else {
					Node node1=new Node();
					node1.value=second;
					if (node1.value!=-1) {
						node1.adj.add(node);
						graph.nodes.put(node1.value, node1);
					}
				}
				int third=scanner.nextInt();
				if (graph.nodes.containsKey(third)) {
					node.adj.add(graph.nodes.get(third));
				}else {
					Node node1=new Node();
					node1.value=third;
					if (node1.value!=-1) {
						node.adj.add(node1);
						graph.nodes.put(node1.value, node1);
					}
				}
			}
		}
//	graph.graphPrint();
		boolean judge=true;
		for (HashMap.Entry<Integer,Node> entry : graph.nodes.entrySet()) {
			LinkedList<Integer> values=new LinkedList<>();
			if (!check(entry.getValue(),values)) {
				System.out.println("Yes");
				judge=false;
				break;
			}
		}
		if (judge) {
			System.out.println("No");
		}
	}
	public boolean check(Node root, LinkedList<Integer> values) {
		if (values.contains(root.value)) {
			return false;
		}
		values.add(root.value);
		for (Node node : root.adj) {
			if (!check(node, values)) {
				return false;
			}
		}
		return true;
	}
}

class Graph{
	HashMap<Integer, Node> nodes=new HashMap<>();
	public void graphPrint() {
		for (HashMap.Entry<Integer,Node> entry : nodes.entrySet()) {
			System.out.print(entry.getValue().value+":");
			for (Node node : entry.getValue().adj) {
				System.out.print(node.value+" ");
			}
			System.out.println();
		}
	}
}

class Node{
	LinkedList<Node> adj=new LinkedList<>();
	int value;
//	public void addNode(Node node) {
//		
//	}
}