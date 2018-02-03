package AVLTree;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.Highlighter.Highlight;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


public class avlTree {
	public static void main(String args[]) {
		new avlTree().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		Tree tree=new Tree();
		int next=scanner.nextInt();
		int num=0;
		while (next!=-1) {
			if (tree.nodes.isEmpty()) {
				tree.root.value=next;
				tree.nodes.put(next, tree.root);
				next=scanner.nextInt();
				continue;
			}
			addNode(next,tree.root,tree);
			maintainHeight(tree.root);
			if (!check(next,tree.root)) {
				tree.deleteNode(next);
				System.out.print(next+" ");
				num++;
			}
			maintainHeight(tree.root);
			next=scanner.nextInt();
		}
		System.out.println(num);
	}
	
	public boolean check(int next,Node root) {
		if (Math.abs(root.lHight-root.rHight)>1) {
			return false;
		}else {
			if(root.value>next){
				if (root.lChild==null) {
					return true;
				}else {
					return check(next, root.lChild);
				}
			}else {
				if (root.rChild==null) {
					return true;
				}else {
					return check(next, root.rChild);
				}
			}
		}
	}
	
	public void maintainHeight(Node root) {
		if (root.lChild!=null) {
			root.lHight=high(root.lChild,1);
			maintainHeight(root.lChild);
		}else {
			root.lHight=0;
		}
		if (root.rChild!=null) {
			root.rHight=high(root.rChild,1);
			maintainHeight(root.rChild);
		}else {
			root.rHight=0;
		}
	}
	
	public int high(Node root, int num) {
		if (root.rChild==null) {
			if (root.lChild==null) {
				return num;
			}else {
				return high(root.lChild, num+1);
			}
		}else {
			if (root.lChild==null) {
				return high(root.rChild, num+1);
			}else {
				int lnum=high(root.lChild, num+1);
				int rnum=high(root.rChild, num+1);
				if (lnum>=rnum) return lnum;
				else return rnum;
			}
		}
	}
	
	public void addNode(int next, Node index, Tree tree) {
		if (next>index.value) {
			
			if (index.rChild!=null) {
				addNode(next, index.rChild, tree);
			}else {
				index.rHight++;
				Node node=new Node();
				node.value=next;
				index.addRChild(node);
				tree.nodes.put(next, node);
			}
		}else {
			if (index.lChild!=null) {
				addNode(next, index.lChild,tree);
			}else {
				index.lHight++;
				Node node=new Node();
				node.value=next;
				index.addLChild(node);
				tree.nodes.put(next, node);
			}
		}
	}
	public boolean compare(Node a, Node b) {
		boolean l=false;
		boolean r=false;
		if ((a.lChild!=null&&b.lChild!=null)) {
			 l=compare(a.lChild, b.lChild);
		}else if (a.lChild==null&&b.lChild==null) {
			l=true;
		}else{
			l=false;
		}
		if ((a.rChild!=null&&b.rChild!=null)) {
			 l=compare(a.rChild, b.rChild);
		}else if (a.rChild==null&&b.rChild==null) {
			l=true;
		}else{
			l=false;
		}
		if (l&&r) {
			return true;
		}else {
			return false;
		}
	}
}

class Tree{
	HashMap<Integer, Node> nodes=new HashMap<>();
	Node root=new Node();
	public void deleteNode(int next) {
		if (nodes.get(next).parent.value>next) {
			nodes.get(next).parent.lChild=null;
		}else {
			nodes.get(next).parent.rChild=null;
		}
		nodes.get(next).parent=null;
	}
}

class Node{
	Node rChild=null;
	Node lChild=null;
	int lHight=0;
	int rHight=0;
	Node parent=null;
	int value;
	public void addLChild(Node node) {
		this.lChild=node;
		node.parent=this;
	}
	public void addRChild(Node node) {
		this.rChild=node;
		node.parent=this;
	}
}

