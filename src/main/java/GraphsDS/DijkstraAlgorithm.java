package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
	static class Pair{
		int first;
		int second;
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
		
	}
	
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
    	int[] dist = new int[V];
    	PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)->x.first-y.first); 
    	
    	Arrays.fill(dist, (int) 1e9);
    	
    	dist[S] = 0;
    	pq.add(new Pair(dist[S], S));
    	while(!pq.isEmpty()) {
    		int node = pq.peek().second;
    		int nodeDist = pq.peek().first;
    		pq.poll();
    		
    		for(ArrayList<Integer> it :adj.get(node)) {
    			int adjNode=it.get(0);
    			int adjNodeWeight = it.get(1);
    			
    			int nD = adjNodeWeight+nodeDist;
    			if((nD)<dist[adjNode]) {
    				dist[adjNode] = nD;
    				pq.add(new Pair(nD, adjNode));
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
