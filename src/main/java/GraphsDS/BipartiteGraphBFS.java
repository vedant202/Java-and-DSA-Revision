package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphBFS {
	
	private static boolean check(int V, ArrayList<ArrayList<Integer>>adj,int[] colors,int startNode){
        Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(startNode);
		colors[startNode] = 0;
		while(!que.isEmpty()) {
			int node = que.peek();
			que.poll();
			
			for(int adjNode:adj.get(node)) {
				if(colors[adjNode]==-1) {
					if(colors[node]==0) {
						colors[adjNode] = 1;
					}else if(colors[node]==1) {
						colors[adjNode] = 0;
					}
					que.add(adjNode);
				}
				else if(colors[node] == colors[adjNode]) {
					return false;
				}
				
			}
			
		}
		
		
		
		return true;
    }
	
	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
		
		 int[] colors = new int[V+1];
			Arrays.fill(colors, -1);
			
			for(int i=0;i<V;i++){
			    if(colors[i]==-1){
			        if(!check(V,adj,colors,i)){
			        return false;
			    }    
			    }
			    
			}
			return true;
    }
	public static void main(String[] args) {
//		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		Graph g = new Graph();
		ArrayList<ArrayList<Integer>> adj = g.makeGraph(5);
		System.out.println(adj);
		boolean isBip =isBipartite(4, adj);
		System.out.println(isBip);
		
	}
}
