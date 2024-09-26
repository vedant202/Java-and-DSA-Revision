package trees;

import trees.PreOrderTraversal.Node;

public class CheckTwoTreesAreEqual {
	
	public static boolean checkTreesEqual(Node root1,Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			System.out.println(root1+" "+root2);
			return false;
		}
		if(root1.data!=root2.data) {
			return false;
		}
		
		
		return checkTreesEqual(root1.left, root2.left) && checkTreesEqual(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.right.left = new Node(6);
		root2.right.right = new Node(7);
		
		System.out.println(checkTreesEqual(root, root2));
	}
}
