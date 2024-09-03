package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseSchedule1 {
	
	public static boolean isPossible(int N,int P, int[][] prerequisites)
    {
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		int m = prerequisites.length;
		
		for(int i=0;i<N;i++) {
			adj.add(i, new ArrayList<Integer>());
		}
		
        // Adj List
		for(int i=0;i<m;i++) {
			
				adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
			
		}
		int[] indegree = new int[N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				indegree[adj.get(i).get(j)]++;
			}
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=0;i<indegree.length;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		
		int cnt = 0;
		while (!que.isEmpty()) {
			
			int node = que.poll();
			
			cnt++;
			
			for(int it:adj.get(node)) {
				indegree[it]--;
				
				if(indegree[it]==0) {
					que.add(it);
				}
			}
		}
		if(cnt==N) return true;
		return false;
		
    }
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{0,1}};
		System.out.println(isPossible(2, 2, prerequisites));
	}
}
