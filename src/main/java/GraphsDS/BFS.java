package GraphsDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFS {
	
	static Map<Integer, ArrayList<Integer>> graphs = new HashMap<Integer, ArrayList<Integer>>();
	
	public static ArrayList<Integer> bfs(Map<Integer, ArrayList<Integer>> graphs,int n) {
		Set<Integer> keys = graphs.keySet();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		boolean visited[] =new boolean[n+1];
		queue.add(graphs.keySet().iterator().next());
		
		visited[graphs.keySet().iterator().next()] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			bfs.add(node);
			for(int it:graphs.get(node)) {
				if(visited[it]==false) {
					queue.add(it);
					visited[it] = true;
				}
				
			}
			
		}
		
		return bfs;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			max = Math.max(max, u);

			max = Math.max(max, v);
			if(graphs.get(u)==null) {
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(v);
				graphs.put(u,t);
			}else {
				graphs.get(u).add(v);
			}
			
			if(graphs.get(v)==null) {
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(u);
				graphs.put(v,t);
			}else {
				graphs.get(v).add(u);
			}
		}
		
		System.out.println(graphs);
		
		System.out.println( bfs(graphs, max));
		
	}
}
