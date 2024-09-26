package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DijkstraAlgorithmUsingSet {
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
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
		Set<Pair> set = new TreeSet<Pair>((x,y)->x.distance-y.distance);
		int[] dist = new int[V];
		
		Arrays.fill(dist, (int)1e9);
		
		dist[S] = 0;
		set.add(new Pair(dist[S], S));
		
		while(!set.isEmpty()) {
			Pair p =set.iterator().next();
			int node = p.node;
			int nodeDist = p.distance;
			set.remove(p);
			
			for(ArrayList<Integer> it:adj.get(node)) {
				int adjNode = it.get(0);
				int adjWeight = it.get(1);
				int nd = nodeDist+adjWeight;
				if(nd<dist[adjNode]) {
					if(dist[adjNode]!=(int)1e9) {
						int td = dist[adjNode];
						set.remove(new Pair(td, adjNode));
						
						
					}
					dist[adjNode] =nd; 
					set.add(new Pair(nd, adjNode));
					
				}
				
			}
		}
		return dist;
		
    }
	public static void main(String[] args) {
		int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};
        
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
          {
              add(node1);
              add(node2);
          }  
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
          {
              add(node3);
              add(node4);
          }  
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
          {
              add(node5);
              add(node6);
          }  
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
		
		System.out.println(Arrays.toString(dijkstra(V, adj, S)));
	}
}
