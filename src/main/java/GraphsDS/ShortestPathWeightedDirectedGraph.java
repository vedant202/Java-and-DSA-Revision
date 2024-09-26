package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import GraphsDS.DijkstraAlgorithmUsingSet.Pair;

public class ShortestPathWeightedDirectedGraph {
	static class Pair{
		int distance;
		int node;
		public Pair(int distance, int node) {
			super();
			this.distance = distance;
			this.node = node;
		}
		@Override
		public String toString() {
			return "Pair [distance=" + distance + ", node=" + node + "]";
		}
		
		
	}
	
	public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		
		for(int i=0;i<m;i++) {
			adj.add(new ArrayList<Pair>());
		}
		
		for(int[] it:edges) {
			adj.get(it[0]).add(new Pair(it[2], it[1]));
			adj.get(it[1]).add(new Pair(it[2], it[0]));
		}
		int parent[] = new int[n+1],dist[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		Arrays.fill(dist, (int)1e9);
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((i,j)->i.distance-j.distance);
		pq.add(new Pair(0,1));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int node = p.node;
			int nodeWeight = p.distance;
			
			for(Pair it:adj.get(node)) {
				int adjNode = it.node;
				int adjNodeDist = it.distance;
				if(nodeWeight+adjNodeDist<dist[adjNode]) {
//					System.out.println((nodeWeight+adjNodeDist)+" "+Arrays.toString(dist)+" "+adjNode);
					dist[adjNode] = nodeWeight+adjNodeDist;
					pq.add(new Pair(dist[it.node],it.node));
					parent[it.node] = node;
				}
			}
		}
		
		List<Integer> path = new ArrayList<Integer>();
		
		
		
		if(dist[n]==1e9) {
			path.add(-1);
			return path;
		}
		
		int cn = n;

//		System.out.println(Arrays.toString(parent));
		while(parent[cn]!=cn) {
			path.add(cn);
			cn = parent[cn];
		}
		path.add(1);
        path.add(dist[n]);

		Collections.reverse(path);
		return path;
		
    }
	
	public static void main(String[] args) {
		int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        List<Integer> path = shortestPath(V,E,edges);
        System.out.println(path);
//        System.out.println(path.get(V));
	}
}
