package AVLTree;
import java.util.Scanner;
public class avlTree {
	public class node{
		public int val;
		public int deep;
		public node leftnode;
		public node rightnode;
		public int highL;
		public int highR;
		public node parent; 
		
		public node(int val, int deep, node parent){
			this.val = val;
			this.deep = deep;
			this.highL=0;
			this.highR=0;
			this.parent = parent;
		}
		
		public boolean addHigh(node child){ //L=0 R=1
			if(child.parent!=null){
				if(child == leftnode){
						child.parent.highL = Math.max(child.highL, child.highR)+1;
						if(Math.abs(this.highL-this.highR)>1)
							return false;
				}
				else if(child == rightnode){
						child.parent.highR = Math.max(child.highL, child.highR)+1;
						if(Math.abs(this.highL-this.highR)>1)
							return false;
				}
				return child.parent.addHigh(this);
			}
			else{
				if(Math.abs(this.highL-this.highR)>1)
					return false;
			}
			return true;
		}
	}
	
	public int sum  = 0;
	
//	public LinkedList<Integer> tree = new LinkedList<>();
	
	
	public void domain(){
		Scanner scan = new Scanner(System.in);
		int number1 = scan.nextInt();
		
		node treeroot = new node(number1,0, null);
		
		while(true){
			int number = scan.nextInt();
			if(number == -1)
				break;
			
			addIntoTree(number,treeroot);
		}
		System.out.println(sum);
	}
	
	private void addIntoTree(int number, node treeroot) {
		if(number<=treeroot.val){
			if(treeroot.leftnode==null){
				node thisnode = new node(number,treeroot.deep+1, treeroot);
				treeroot.leftnode = thisnode;
				if(!treeroot.addHigh(thisnode)){
					sum++;
					System.out.print(number+" ");
				}
			}
			else{
				addIntoTree(number, treeroot.leftnode);
			}
		}
		else{
			if(treeroot.rightnode==null){
				node thisnode = new node(number,treeroot.deep+1, treeroot);
				treeroot.rightnode = thisnode;
				if(!treeroot.addHigh(thisnode)){
					sum++;
					System.out.print(number+" ");
				}
			}
			else
				addIntoTree(number, treeroot.rightnode);
		}
	}

	public static void main(String[] args) {
		
		new avlTree().domain();
		
	}
}



