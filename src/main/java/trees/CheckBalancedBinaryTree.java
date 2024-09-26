package trees;

import trees.PreOrderTraversal.Node;

public class CheckBalancedBinaryTree {
	
	public static boolean check(Node root) {
		if(root==null) {
			return true;
		}
		
		int lh = findH(root.left);
		int rh = findH(root.right);
		if(Math.abs(lh-rh)>1) {
			return false;
		}
		boolean left = check(root.left);
		boolean right = check(root.right);
		
		if(!left || !right) {
			return false;
		}
		return true;
	}
	
	public static int findH(Node root) {
		if(root==null) {
			return 0;
		}
		
		return 1+Math.max(findH(root.left), findH(root.right));
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		root.left.left.left.left = new Node(9);
//		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(check(root));
	}
}
