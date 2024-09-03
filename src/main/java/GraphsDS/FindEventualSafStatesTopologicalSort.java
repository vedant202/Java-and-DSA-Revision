package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FindEventualSafStatesTopologicalSort {
	static List<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
		ArrayList<ArrayList<Integer>> adjRev = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<V;i++) {
			adjRev.add(new ArrayList<Integer>());
		}
		
		int[] indegree = new int[V];
		for(int i=0;i<V;i++) {
			for(int it:adj.get(i)) {
				adjRev.get(it).add(i);
				indegree[i]++;
			}
		}
		System.out.println(adjRev);
		Queue<Integer> que= new LinkedList<Integer>();
//		for(int i=0;i<V;i++) {
//			for(int it:adjRev.get(i)) {
//				indegree[it]++;
//			}
//		}
		List<Integer> safeNodes = new ArrayList<Integer>();
		for(int i=0;i<indegree.length;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		System.out.println(Arrays.toString(indegree));
		while(!que.isEmpty()) {
			int node = que.poll();
			safeNodes.add(node);
			
			for(int it:adjRev.get(node)) {
				indegree[it]--;
				if(indegree[it]==0) {
					que.add(it);
				}
			}
		}
		Collections.sort(safeNodes);
		return safeNodes;
		
    }
	
	public static void main(String[] args) {
		
	
		int m=14;
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
		System.out.println(topoSort(12, adj));
	}
}
