package trees;

import trees.PreOrderTraversal.Node;

public class MaxPathSumBinaryTree {
	private static int max = 0;
	public static int maxPathSum(Node root) {
		if(root==null) {
			return 0;
		}
		int lh = maxPathSum(root.left);
		int rh = maxPathSum(root.right);
		max = Math.max(max, lh+rh+root.data);
		
		return root.data+Math.max(lh, rh);
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(maxPathSum(root));
		System.out.println(max);
	}
}
