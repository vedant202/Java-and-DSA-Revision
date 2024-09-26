package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.PreOrderTraversal.Node;

public class IterativeTraversal {
	public static void inOrderTraversal(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true) {
			if(node!=null) {
				stack.add(node);
				node = node.left;
				
			}else {
				if(stack.isEmpty()) {
					break;
				}
				node = stack.peek();
				stack.pop();
				System.out.println(node.data);
				node = node.right;
			}
			
		}
	}
	
	public static void postOrderTraverals(Node root) {
		Node node = root;
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.add(node);
		
		while(!stack1.isEmpty()) {
			Node n = stack1.pop();
			stack2.add(n);
			if(n.left!=null) {
				stack1.add(n.left);
			}
			if(n.right!=null) {
				stack1.add(n.right);
			}
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data+" ");
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
//		inOrderTraversal(root);
		postOrderTraverals(root);
	}
}
