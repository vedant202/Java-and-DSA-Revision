package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// This Problem i have done using bfs

public class DetectCycle {
	
	static class Pair{
		int first;
		int second;
		
		Pair(int f,int s){
			this.first = f;
			this.second = s;
		}
	}
	
	
	public static boolean detectCycle(int V,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int src) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(src,-1));
		vis[src] = true;
		while(!queue.isEmpty()) {
			
			int node = queue.peek().first;
			int prevN = queue.peek().second;
			queue.poll();
			for(int i:adj.get(node)) {
				
				if(!vis[i]) {
					vis[i] = true;
					queue.add(new Pair(i,node));
				}else if(vis[i] && i!= prevN) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean vis[] = new boolean[V];
		
		
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				if(detectCycle(V, adj, vis, i)) return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<adj.length;i++) {
			for(int j=0;j<adj[i].length;j++) {
				adjList.add(new ArrayList<Integer>());
			}}
		
		for(int i=0;i<adj.length;i++) {
			for(int j=0;j<adj[i].length;j++) {
				try {
					if(adj[i].length>0) {
						adjList.get(i).add(adj[i][j]);
					}
					
				} catch (IndexOutOfBoundsException e) {
					// TODO: handle exception
					if(adj[i].length>0) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(adj[i][j]);
						adjList.add(temp);
					}
					
				}
				
			}
		}
		
		System.out.println(adjList);
		
		System.out.println(isCycle(5, adjList));
		
	}
}
