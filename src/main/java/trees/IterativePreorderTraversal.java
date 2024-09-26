package trees;

import java.util.Stack;

import trees.PreOrderTraversal.Node;

public class IterativePreorderTraversal {
	
	public static void preOrderTraversal(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			System.out.println(n.data);
			if(n.right!=null) {
				stack.add(n.right);
			}
			if(n.left!=null) {
				stack.add(n.left);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		preOrderTraversal(root);
	}
}
