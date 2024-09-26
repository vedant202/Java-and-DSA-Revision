package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.LevelOrderTraversal.Node;

public class ZigZagTraversal {
	
	public static List<List<Integer>> zigZagTraversal(Node root){
		Queue<Node> que = new LinkedList<Node>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		boolean flag = true;
		
		que.add(root);
		while(!que.isEmpty()) {
			
			
			List<Integer> level = new ArrayList<Integer>();
			int s = que.size();
			for(int i=0;i<s;i++) {
				Node n = que.poll();
				
					if(n.left!=null) {
						que.add(n.left);
					}
					if(n.right!=null) {
						que.add(n.right);
					}
					
				
					
				level.add(n.data);
			}
			if(flag) {
				
				ans.add(level);
			}else {
				Collections.reverse(level);
				ans.add(level);
			}
			flag = !flag;
			
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(zigZagTraversal(root));
	}
}
