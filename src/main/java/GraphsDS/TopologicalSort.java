package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
	
	static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,Stack<Integer> st) {
		vis[node] = true;
		
		for(int it:adj.get(node)) {
			if(!vis[it]) {
				dfs(adj, vis, it, st);
			}
		}
		st.push(node);
		
	}
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
		boolean[] vis = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				dfs(adj,vis,i,st);
			}
		}
		
		int res[] =new int[st.size()];
		int i=0;
		while(!st.isEmpty()) {
			res[i] = st.pop();
			i++;
		}
		return res;
    }
	
	public static void main(String[] args) {
		Graph g = new Graph();
		int m=6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<m;i++) {
			adj.add(new ArrayList<Integer>());	
		}
		
		for(int i=0;i<m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(u== -1 && v==-1) {
				break;
			}
			try {
				adj.get(u).add(v);
			} catch (Exception e) {
				// TODO: handle exception
				adj.add(u,new ArrayList<Integer>());
				adj.get(u).add(v);

			}
			
		}
		System.out.println(adj);
		System.out.println(Arrays.toString(topoSort(m,adj)));
	}
}
