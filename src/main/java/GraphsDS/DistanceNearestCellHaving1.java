package GraphsDS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
public class DistanceNearestCellHaving1 {
	
	static class Pair{
		int first;
		int second;
		int dist;
		public Pair(int first, int second, int dist) {
			super();
			this.first = first;
			this.second = second;
			this.dist = dist;
		}
		
		
	}
	
	static void bfs(int[][] grid,boolean[][] vis,int[][] distMatr) {
		Queue<Pair> queue = new LinkedList<Pair>();
		int m = grid.length;
		int n = grid[0].length;
		
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(!vis[i][j] && grid[i][j]==1) {
					vis[i][j] = true;
					
					queue.add(new Pair(i, j, 0));
				}
				
			}
		}
		
		
		while(!queue.isEmpty()) {
			int r = queue.peek().first;
			int c = queue.peek().second;
			int dist = queue.peek().dist;
			
			queue.poll();
			
			distMatr[r][c] = dist;
//			Down
			if(r+1<m && !vis[r+1][c] &&  grid[r+1][c]==0) {
					vis[r+1][c] = true;
					queue.add(new Pair(r+1, c, dist+1));
				
			}
//			Up
			if(r-1>=0 && !vis[r-1][c] && r-1<m && grid[r-1][c]==0) {
				vis[r-1][c] = true;
				queue.add(new Pair(r-1, c, dist+1));
			
			}
//			Right
			if(c+1<n && c+1>=0 && !vis[r][c+1] &&  grid[r][c+1]==0) {
				vis[r][c+1] = true;
				queue.add(new Pair(r, c+1, dist+1));
			
			}
//			Left
			if(c-1>=0 && !vis[r][c-1] && c-1<n && grid[r][c-1]==0) {
				vis[r][c-1] = true;
				queue.add(new Pair(r, c-1, dist+1));
			
			}
		}
		
	}
	
	//Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest(int[][] grid)
    {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] distMatr = new int[grid.length][grid[0].length];
        
        bfs(grid,vis,distMatr);
        
        return distMatr;
    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,1},{1,1,0},{1,0,0}};
		
		int[][] dist = nearest(grid);
		
		for(int[] i:dist) {
			System.out.println(Arrays.toString(i));
		}
	}

}
