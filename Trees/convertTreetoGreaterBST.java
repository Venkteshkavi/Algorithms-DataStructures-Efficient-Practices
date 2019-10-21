import java.util.*;

public class convertTreetoGreaterBST {
	
	public class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node convertToGBST(Node root) {
		if(root == null)
			return null;
		int sum = 0;
		helper(root,sum);
		return root;
	}
	
	
	public static int helper(Node root,int sum) {
		if(root == null)
			return 0;
		int r = helper(root.right,sum);
		root.data = root.data + Math.max(r,  sum);
		sum = root.data;
		int l = helper(root.left,sum);
		return Math.max(l, root.data);
	}
	
	static void printLevelOrder(Node root) {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(true) {
			int nodeCount = q.size();
			if(nodeCount==0)
				break;
		while(nodeCount>0) {
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			nodeCount--;
		}

		System.out.println();

		}
	}
	
	
	public static void main(String[] args) {
		convertTreetoGreaterBST obj = new convertTreetoGreaterBST();
		Node root = obj.new Node(50);
		root.left = obj.new Node(30);
		root.right = obj.new Node(70);
		root.left.left = obj.new Node(20);
		root.left.right = obj.new Node(40);
		root.right.left = obj.new Node(60);
		root.right.left.right = obj.new Node(65);
		root.right.right = obj.new Node(80);
		printLevelOrder(root);
		convertToGBST(root);
		System.out.println("#######");
		printLevelOrder(root);
	}
}
