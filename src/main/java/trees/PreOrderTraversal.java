package trees;

public class PreOrderTraversal {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left = null;
			this.right=null;
			
		}
		
	}
	
	public static void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	static void postOrdeTraversal(Node root) {
		if(root==null) {
			return;
		}
		postOrdeTraversal(root.left);
		postOrdeTraversal(root.right);
		System.out.println(root.data);
	}
	static void inOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
//		System.out.println(root.left.left.d);
		inOrderTraversal(root);
	}
}
