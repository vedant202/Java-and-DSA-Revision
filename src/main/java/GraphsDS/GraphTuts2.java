package GraphsDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GraphTuts2 {
	static List<List<Integer>> graphs = new ArrayList<List<Integer>>();
	
	public static ArrayList<Integer> bfs(List<List<Integer>> graphs, int V){
		boolean[] vis = new boolean[V+1];
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(0);
		vis[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			bfs.add(node);
			
			for(int it:graphs.get(node)) {
				if(!vis[it]) {
					q.add(it);
					vis[it] = true;
				}
			}
		}
		
		return bfs;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int m = sc.nextInt();
		
		for(int i=0;i<m;i++) {
			graphs.add(new ArrayList<Integer>());
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			max = Math.max(max, u);
			max = Math.max(max, v);
			
			try {
				graphs.get(u).add(v);
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				List<Integer> list= new ArrayList<Integer>();
				list.add(v);
				graphs.add(u,list);
			}
			
			try {
				graphs.get(v).add(u);
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				List<Integer> list= new ArrayList<Integer>();
				list.add(u);
				graphs.add(v,list);
			}

		}
		
		System.out.println(graphs);
		
		for(int i=0;i<graphs.size();i++) {
				System.out.print(i+":- "+graphs.get(i)+" ");
			System.out.println();
		}
		
		System.out.println(bfs(graphs, m));
	}

}
