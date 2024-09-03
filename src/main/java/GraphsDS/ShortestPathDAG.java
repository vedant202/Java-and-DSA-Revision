package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class ShortestPathDAG {
	
	static class Pair{
		int first;
		int second;
		
		Pair(int f,int s){
			this.first = f;
			this.second = s;
		}

		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
		
		
	}
	
	static void topoSortDfs(ArrayList<ArrayList<Pair>> adj,Stack<Integer> stack,boolean[] vis,int v,int node ) {
		
		vis[node] = true;
			for(Pair p:adj.get(node)) {
				if(!vis[p.first])
					topoSortDfs(adj, stack, vis, v,p.first);
			}
		stack.push(node);
		
		
		
	}
	
	public static int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		
		for(int i=0;i<N;i++) {
			adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0;i<edges.length;i++) {
			adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
//		System.out.println(adj);
		Stack<Integer> stack = new Stack<Integer>();
		
		
		boolean[] vis = new boolean[N];
		
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				topoSortDfs(adj, stack,vis, M, i);

			}
		}
		
		int[] dis = new int[N];
		Arrays.fill(dis, (int) 1e9);
		dis[0] = 0;
//		System.out.println(Arrays.toString(dis));
		while(!stack.isEmpty()) {
			int node = stack.pop();
//			System.out.println(node);
			for(Pair p:adj.get(node)) {
//				System.out.println(p);
				int wt = p.second;
				int v = p.first;
				if(dis[node]+wt<dis[v]) {
					dis[v] = dis[node]+wt;
				}
			}
			
			 
		}
		for(int i=0;i<dis.length;i++) {
			if(dis[i]==(int)1e9) dis[i]=-1;
		}
		
//		System.out.println(Arrays.toString(dis));
		return dis;
		
	}
	
	public static void main(String[] args) {
		int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

		int n=6;
		int m=7;
		System.out.println( Arrays.toString( shortestPath(n, m, edge)));
	}
}
