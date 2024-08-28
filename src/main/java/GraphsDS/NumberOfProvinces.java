package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfProvinces {
	
	static void dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] vis) {
		vis[node] = true;
		for(int it:adj.get(node)) {
			if(!vis[it]) {
				dfs(adj, it, vis);
			}
		}
	}
	
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
		boolean[] visi = new boolean[V+1];
		int res = 0;
		
		
		for(int i=0;i<adj.size();i++) {
			
			if(adj.get(i).size()>0 && !visi[i]) {
				dfs(adj,i,visi);
				res ++;
			}
			
		}
		return res;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		for(int i=0;i<n;i++) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int j=0;j<m;j++) {
				t.add(0);
			}
			matrix.add(t);
		}
		System.out.println(m+" "+n);
		for(int i=0;i<m;i++) {
			System.out.println(i);
				int u = sc.nextInt();
				int v = sc.nextInt();
				matrix.get(u).set(v, 1);
				matrix.get(v).set(u, 1);
		}
		
		System.out.println(matrix);
		
		for(int i=0;i<m;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix.get(i).get(j)==1) {
					
					if(adj.get(i).size()>0) {
						adj.get(i).add(j);
					}else {
						ArrayList<Integer> t = new ArrayList<Integer>();
						t.add(j);
						
						adj.add(i,t);
					}
					
					
				}
			}
		}
		
		int res = numProvinces(adj, 1);
		System.out.println(res);
		
	}
}
