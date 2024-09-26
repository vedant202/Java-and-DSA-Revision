package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTraversal {
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
	
	public static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			for(int i=0;i<size;i++) {
				Node n = queue.poll();
				
				if(n.left!=null) {
					queue.add(n.left);
				}
				
				if(n.right!=null) {
					queue.add(n.right);
				}
				
				level.add(n.data);
				
			}
			ans.add(level);
		}
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		levelOrderTraversal(root);
	}
}
