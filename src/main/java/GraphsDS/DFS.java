package GraphsDS;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	
	public static void recuBst(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int node,ArrayList<Integer> res,int v) {
		res.add(node);
		vis[node] = true;
		
		for(int i :graph.get(node)) {
			if(!vis[i]) {
				recuBst(graph, vis, i, res, v);
				
			}
		}
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph,int sn,int v) {
		boolean[] vis = new boolean[v+1];
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		res.add(sn);
		vis[sn] = true;
		stack.add(sn);
		recuBst(graph,vis, sn,res,v);
		System.out.println(res);
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		ArrayList<ArrayList<Integer>> graph = g.makeGraph(3);
		System.out.println(graph);
		dfs(graph, 1,4);
	}

}
