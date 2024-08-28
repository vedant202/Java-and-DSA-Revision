package GraphsDS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	
	static class Pair{
		int first;
		int second;
		int tm;
		public Pair(int first, int second, int tm) {
			super();
			this.first = first;
			this.second = second;
			this.tm = tm;
		}
		
		
	}
	
	
	public static int orangesRotting(int[][] grid)
    {
        // Code here
		
		Queue<Pair> queue = new LinkedList<Pair>();
		int maxTime = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] vis = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==2) {
					vis[i][j] = 2;
					queue.add(new Pair(i,j,0));
				}
			}
		}
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		int tm = 0;
		while(!queue.isEmpty()) {
			
			int row = queue.peek().first;
			int col = queue.peek().second;
			
			int t = queue.peek().tm;
			tm = Math.max(tm, t);
			queue.poll();
			
			for(int i=0;i<4;i++) {
				int nrow = row+dr[i];
				int ncol = col+dc[i];
				
				if(nrow>=0 && nrow<m && ncol>=0 && ncol<n) {
					if(vis[nrow][ncol]!=2 && grid[nrow][ncol]==1) {
						grid[nrow][ncol]=2;
						queue.add(new Pair(nrow, ncol, t+1));
					}
				}
			}
			
		}
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==1 && vis[i][j]!=2) {
					return -1;
				}
			}
		}
		
		return tm;
		
    }
	
	public static void main(String[] args) {
		int[][] grid = {{0,2,1},{0,1,1},{1,0,1}};
		
		int count = orangesRotting(grid);
		System.out.println(count);
	}
}
