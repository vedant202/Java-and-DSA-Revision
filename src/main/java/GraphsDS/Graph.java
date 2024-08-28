package GraphsDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	public ArrayList<ArrayList<Integer>> makeGraph(int m){
		ArrayList<ArrayList<Integer>> graphs = new ArrayList<ArrayList<Integer>>();
         Scanner sc= new Scanner(System.in);
		
		
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
				ArrayList<Integer> list= new ArrayList<Integer>();
				list.add(v);
				graphs.add(u,(ArrayList<Integer>) list);
			}
			
			try {
				graphs.get(v).add(u);
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				ArrayList<Integer> list= new ArrayList<Integer>();
				list.add(u);
				graphs.add(v,list);
			}

		}
		
		return graphs;
	}
	public static void main(String[] args) {
		Graph g = new Graph();
		var grap = g.makeGraph(3);
		System.out.println(grap);
	}
}
