package GraphsDS;

import java.util.ArrayList;

public class DetectCycleDFS {
	
	public static boolean  dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,int p) {
		
		vis[node] = true;
		
		for(int it:adj.get(node)) {
			
			if(!vis[it]) {
				var bool = dfs(adj, vis, it,node);
				if(bool) {
					return true;
				}
				
			}else if(it!=p) {
				return true;
			}
			
				
				
	}
		
		return false;
	}
	
	
	
	
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis =new boolean[V];
		
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				boolean checkCy = dfs(adj, vis, i,-1);
				System.out.println("checkCy "+checkCy);
				if(checkCy) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
int[][] adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} ;
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<adj.length;i++) {
			
				adjList.add(new ArrayList<Integer>());
			}
		
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
