package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {
	
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis, boolean[] path,int node) {
		if(vis[node] && path[node]) return true;
		
		vis[node] = true;
		path[node] = true;
		
		for(int i:adj.get(node)) {
			if(!vis[i] ) {
				if(!path[i]) {
					
					
					if(dfs(adj, vis, path, i)) {
//						System.out.print("path :- "+i);
					
						path[node] = false;
						return true;
					}
//				Backtrack
				}
				
			}
			else if(vis[i] && path[i]) {
				return true;
			}
		}
		path[node] = false;
		return false;
		
	}
	
	
	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
		boolean[] vis = new boolean[V+1];
		boolean[] path = new boolean[V+1];
		
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				boolean c = dfs(adj, vis, path, i);
//				System.out.println(i+" "+c);
//				System.out.println(Arrays.toString(vis));
//				System.out.println(Arrays.toString(path));
				if(c) {
					
					return true;
				}
			}
		}
		
		
		return false;
    }
	
	public static void main(String[] args) {
//		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		Graph g = new Graph();
		int m=6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<m+1;i++) {
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
		System.out.println( isCyclic(6,adj));
	}
}
