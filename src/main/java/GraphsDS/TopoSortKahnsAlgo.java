package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopoSortKahnsAlgo {
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
		int inDegree[] = new int[V];
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				inDegree[adj.get(i).get(j)]++;
			}
		}
		
		System.out.println(Arrays.toString(inDegree));
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				que.add(i);
			}
		}
		int[] res = new int[V];
		int i=0;
		while(!que.isEmpty()) {
			int node = que.poll();
			res[i++] = node;
			for(int it:adj.get(node)) {
				inDegree[it]--;
				if(inDegree[it]==0) {
					que.add(it);
				}
			}
		}
		
		return res;
		
    }
	public static void main(String[] args) {
		Graph g = new Graph();
		int m=6;
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
		System.out.println(Arrays.toString(topoSort(m,adj)));
	}

}
