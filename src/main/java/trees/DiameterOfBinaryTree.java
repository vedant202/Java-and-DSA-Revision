package trees;

import trees.PreOrderTraversal.Node;

public class DiameterOfBinaryTree {
	static int max = 0;
	public static int diameterOfBinaryTree(Node root) {
		if(root==null) {
			return 0; 
		}
		
		int lh = height(root.left);
		int rh = height(root.right);
		max = Math.max(max, lh+rh);
		System.out.println(root.data+" :- "+max);
		diameterOfBinaryTree(root.left);
		diameterOfBinaryTree(root.right);
		return max;
	}
	
	public static int diameterOfBinaryTree2(Node root) {
		if(root==null) {
			return 0; 
		}
		
		int lh = diameterOfBinaryTree2(root.left);
		int rh = diameterOfBinaryTree2(root.right);
		max = Math.max(max, lh+rh);
		
		return 1+Math.max(lh, rh);
	}
	
	
	public static int height(Node root) {
		if(root==null) return 0;
		
		return 1 + Math.max(height(root.left),height(root.right));
	}
	
//	public static int rh(Node root) {
//		if(root==null) return 0;
//		
//		return 1 + rh(root.right);
//	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.left.left.left = new Node(9);
		root.right.left.left.left.left = new Node(10);
		
		System.out.println(diameterOfBinaryTree2(root));
	}
}
