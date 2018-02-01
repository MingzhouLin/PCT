package FamilyTreeRelationship;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class familyTree {
	public static void main(String args[]) {
		new familyTree().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		scanner.nextLine();
		Tree relation=new Tree();
		for (int i = 0; i < N; i++) {
			if (i==0) {
				String[] members=scanner.nextLine().split("\\s+");
				relation.root.name=members[0];
				relation.nodes.put(members[0], relation.root);
				Node newNode=new Node();
				newNode.name=members[1];
				relation.root.addLChild(newNode);
				relation.nodes.put(newNode.name, newNode);
				continue;
			}
			String[] members=scanner.nextLine().split("\\s+");
			if (relation.nodes.containsKey(members[0])) {
				if (relation.nodes.get(members[0]).lChild==null) {
					Node newNode=new Node();
					newNode.name=members[1];
					relation.nodes.get(members[0]).addLChild(newNode);
					relation.nodes.put(newNode.name, newNode);
				}else if (relation.nodes.get(members[0]).rChild==null) {
					Node newNode=new Node();
					newNode.name=members[1];
					relation.nodes.get(members[0]).addRChild(newNode);
					relation.nodes.put(newNode.name, newNode);
				}else{
					continue;
				}
			}else {
				continue;
			}
		}
		int m=scanner.nextInt();
		scanner.nextLine();
		char[] judge=new char[m];
		for (int i = 0; i < m; i++) {
			String[] rel=scanner.nextLine().split("\\s+");
			if (judge(rel,relation)) judge[i]='T';
			else judge[i]='F';		
		}
		for (int i = 0; i < m; i++) {
			if (i==0) {
				System.out.print(judge[i]);
				continue;
			}
			System.out.print(" "+judge[i]);	
		}
		System.out.println();
		preOrderPrint(relation);
		
	}
	public boolean judge(String[] rel, Tree relation) {
		if (rel[1].equals("child")) {
			if (relation.nodes.get(rel[0]).parent!=null) {
				if (relation.nodes.get(rel[0]).parent.equals(relation.nodes.get(rel[2]))) return true;
			else return false;
			}		
		}
		if (rel[1].equals("parent")) {
			if (relation.nodes.get(rel[2]).parent!=null) {
				if (relation.nodes.get(rel[2]).parent.equals(relation.nodes.get(rel[0]))) return true;
				else return false;
			}else {
				return false;
			}
		}
		if (rel[1].equals("sibling")) {
			if (relation.nodes.get(rel[2]).parent!=null&&relation.nodes.get(rel[0]).parent!=null) {
				if (relation.nodes.get(rel[2]).parent.equals(relation.nodes.get(rel[0]).parent)) return true;
				else return false;
			}else {
				return false;
			}
		}
		if (rel[1].equals("descendant")) {
			return check(relation.nodes.get(rel[2]),rel[0]);
		}
		if (rel[1].equals("ancestor")) {
			return check(relation.nodes.get(rel[0]),rel[2]);
		}
		return false;
	}
	
	public boolean check(Node root,String name) {
		if (root.name.equals(name)) {
			return true;
		}
		if (root.lChild!=null) {
		    if (check(root.lChild, name)) {
		    		return true;
			}
		}
		if (root.rChild!=null) {
			if (check(root.rChild, name)) {
				return true;
			} 
		}
		return false;
	}
	
	public void preOrderPrint(Tree tree) {
		System.out.print(tree.root.name);
		preOrder(tree.root);
		System.out.println();
	}
	
	public void preOrder(Node root) {
		if (root.lChild!=null) {
			System.out.print(" "+root.lChild.name);
			preOrder(root.lChild);
		}
		if (root.rChild!=null) {
			System.out.print(" "+root.rChild.name);
			preOrder(root.rChild);
		}
	}
}

class Tree{
	HashMap<String, Node> nodes=new HashMap<>();
	Node root=new Node();
}

class Node{
	Node lChild=null;
	Node rChild=null;
	Node parent=null;
	String name;
	public void addLChild(Node lchild) {
		this.lChild=lchild;
		lchild.parent=this;
	}
	public void addRChild(Node rchild) {
		this.rChild=rchild;
		rchild.parent=this;
	}
}