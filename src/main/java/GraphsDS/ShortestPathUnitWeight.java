package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathUnitWeight {
	
	static class Pair{
		int first;
		int second;
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
		
		
	}
	
	public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
		
		int[] dist = new int[n];
		int max = (int) 1e9;
		Arrays.fill(dist, max);
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		System.out.println(adj);
		Queue<Pair> que = new LinkedList<Pair>();
		
		que.add(new Pair(src,0));
		dist[src]=0;
		while(!que.isEmpty()) {
			Pair node = que.poll();
			int v = node.first;
			int w = node.second;
			for(Integer it:adj.get(node.first)) {
				if(dist[it]==1e9) {
					dist[it] = Math.min(dist[it],w+1);
					que.add(new Pair(it, dist[it]));
				}
				
			}
		}
		
		for(int i=0;i<dist.length;i++) {
			if(dist[i]==1e9) {
				dist[i] = -1;
			}
		}
		
		return dist;
    }
	
	public static void main(String[] args) {
		int n = 9, m = 10;
		int[][] edges={{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
		shortestPath(edges,n,m,0);
	}
}
