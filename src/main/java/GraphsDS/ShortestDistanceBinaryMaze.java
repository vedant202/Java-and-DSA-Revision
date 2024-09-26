package GraphsDS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {
	
	
	
	static int shortestPath(int[][] grid, int[] source, int[] destination) {
		int n=grid.length, m= grid[0].length;
		int[][] dist = new int[n][m];
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dist[i][j] = (int)1e9;
			}
		}
		
		dist[source[0]][source[1]] = 0;
		
		que.add(new int[] {0,source[0],source[1]});
		
		while(!que.isEmpty()) {
			int[] arrNode =  que.poll();
			int nodeDist = arrNode[0];
			int r = arrNode[1];
			int c = arrNode[2];
			System.out.println(Arrays.toString(arrNode));
			
			if(r==destination[0] && c==destination[1]) {
				return nodeDist;
			}
			
			//right
			if(r>=0 && r<n && c+1>=0 && c+1<m && grid[r][c+1]!=0  ) {
				if(dist[r][c+1]==1e9) {
					dist[r][c+1] = nodeDist+1;
					que.add(new int[] {nodeDist+1,r,c+1});
				}
				
			}
			//left
			if(r>=0 && r<n && c-1>=0 && c-1<m && grid[r][c-1]!=0  ) {
				if(dist[r][c-1]==1e9) {
					dist[r][c-1] = nodeDist+1;
					que.add(new int[] {nodeDist+1,r,c-1});
				}
				
			}
			
			//up
			if(r-1>=0 && r-1<n && c>=0 && c<m && grid[r-1][c]!=0  ) {
				if(dist[r-1][c]==1e9) {
					dist[r-1][c] = nodeDist+1;
					que.add(new int[] {nodeDist+1,r-1,c});
				}
				
			}
			//down
			if(r+1>=0 && r+1<n && c>=0 && c<m && grid[r+1][c]!=0  ) {
				if(dist[r+1][c]==1e9) {
					dist[r+1][c] = nodeDist+1;
					que.add(new int[] {nodeDist+1,r+1,c});
				}
				
			}
			
		}
		return -1;
		
    }
	public static void main(String[] args) {
		int grid[][] ={{1, 1, 1, 1},
	            {1, 1, 0, 1},
	            {1, 1, 1, 1},
	            {1, 1, 0, 0},
	            {1, 0, 0, 1}};
		int[] source = {0, 1};
		int[] destination = {2, 2};
		System.out.println(shortestPath(grid, source, destination));
	}
}
