package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleTopologicalSort {
	
	// Here I am using Topological graph algorithm to detect cycle in graph
	
	
	static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
		boolean[] vis = new boolean[V];
		Queue<Integer> que = new LinkedList<Integer>();
		
		int[] inDegree = new int[V];
		
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				inDegree[adj.get(i).get(j)]++;
			}
		}
		
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				que.add(i);
			}
		}
		
		int cnt = 0;
		
		while(!que.isEmpty()) {
			
			int node = que.poll();
			cnt++;
			
			for(int it:adj.get(node)) {
				inDegree[it]--;
				
				if(inDegree[it]==0) que.add(it);
			}
		}
		
		if(cnt==V) {
			return false;
		}
		return true;
		
    }
	
	
	public static void main(String[] args) {
		Graph g = new Graph();
		int m=4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
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
		System.out.println(topoSort(m,adj));
		if(topoSort(m,adj)) {
			System.out.println("Cycle is present");
		}else {
			System.out.println("Cycle is not present");
		}
	}
}
