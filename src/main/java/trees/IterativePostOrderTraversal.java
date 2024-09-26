package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.PreOrderTraversal.Node;

//Iterative Post Order Traversal using Single Stack

public class IterativePostOrderTraversal {
	
	public static List<Integer> postOrderTraversal(Node root){
		
		Stack<Node> st = new Stack<Node>();
		Node curr = root;
		List<Integer> postOrd = new ArrayList<Integer>();
		while(curr!=null || !st.isEmpty()) {
			if(curr!=null) {
				st.add(curr);
				curr = curr.left;
			}else {
				Node temp = st.peek().right;
				
				if(temp==null) {
					temp = st.pop();
					postOrd.add(temp.data);
					while(!st.isEmpty() && temp == st.peek().right) {
						temp = st.pop();
						postOrd.add(temp.data);
					}
					
					
				}else {
					curr = temp;
				}
				
			}
		}
		
		return postOrd;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		List<Integer> res=postOrderTraversal(root);
		System.out.println(res);
	}
}
