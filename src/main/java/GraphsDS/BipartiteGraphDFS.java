package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {

	private static boolean checkDFs(ArrayList<ArrayList<Integer>> adj, int[] colors, int col, int startNode) {

		colors[startNode] = col;

		for (int i : adj.get(startNode)) {
			if (colors[i] == -1) {
				if (checkDFs(adj, colors, 1 - col, i) == false)
					return false;
			} else if (colors[i] == col) {
				return false;
			}

		}
		return true;
	}

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int colors[] = new int[V + 1];

		Arrays.fill(colors, -1);
//		System.out.println(checkDFs(adj, colors, 0, 0));
		for (int i = 0; i < V; i++) {
			if (colors[i] == -1) {
				if (!checkDFs(adj, colors, 0, 0)) {
					return false;
				}
			}

		}
		return true;

	}

	public static void main(String[] args) {
//		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		Graph g = new Graph();
		ArrayList<ArrayList<Integer>> adj = g.makeGraph(4);
		System.out.println(adj);
		boolean isBip = isBipartite(4, adj);
		System.out.println(isBip);

	}
}
//0 1
//1 2
//1 4
//2 3
//3 4