package GraphsDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindEventualSafeStates {
	
	public static boolean dfs(List<List<Integer>> adj,boolean vis[],boolean pathVis[],boolean check[],int node) {
		
		vis[node] = true;
		pathVis[node] = true;
		
		for(int i:adj.get(node)) {
			if(!vis[i] && !pathVis[i]) {
				if(dfs(adj, vis, pathVis, check, i)) {
					return true;
				}
			}else if(pathVis[i]) {
				return true;
			}
		}
		pathVis[node] = false;
		check[node] = true;
		return false;
	}
	
	static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
		boolean vis[] = new boolean[V+1];
		boolean pathVis[] = new boolean[V+1];
		boolean check[] = new boolean[V+1];
		List<Integer> safeNodes= new ArrayList<Integer>();
		
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				dfs(adj,vis,pathVis,check,i);
			}
				
			
		}
        
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				safeNodes.add(i);
			}
		}
		return safeNodes;
    }
	
	
	public static void main(String[] args) {
		Graph g = new Graph();
		int m=8;
		List<List<Integer>> adj = new ArrayList<>();
		
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
		System.out.println(eventualSafeNodes(m, adj));
		
	}

}
