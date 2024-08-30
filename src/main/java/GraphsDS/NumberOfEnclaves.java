package GraphsDS;

import java.util.Arrays;

public class NumberOfEnclaves {
// https://www.geeksforgeeks.org/problems/number-of-enclaves/1
	
	
	static void dfs(int[][] grid, boolean[][] vis, int m, int n, int r, int c) {
//		System.out.println(r+" "+c);
		if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || grid[r][c] == 0) {
			return;
		}
		vis[r][c] = true;
		dfs(grid, vis, m, n, r + 1, c);
		dfs(grid, vis, m, n, r - 1, c);
		dfs(grid, vis, m, n, r, c + 1);
		dfs(grid, vis, m, n, r, c - 1);
	}

	static int numberOfEnclaves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		System.out.println(m+" "+n);
		boolean vis[][] = new boolean[m][n];
		int count = 0;

		int i = 0;
//        Down
		while (i < m) {
//			System.out.println(grid[i][0]+ " "+ (!vis[i][0] && grid[i][0] == 1));
			if (!vis[i][0] && grid[i][0] == 1) {
				dfs(grid, vis, m, n, i, 0);
			}
			i++;
		}

		
		
		//      Down Right
		i = 0;
		while (i < n) {
			if (!vis[m - 1][i] && grid[m - 1][i] == 1) {
				dfs(grid, vis, m, n, m - 1, i);
			}
			i++;
		}

//    right up to right down
		i = 0;
		while (i < m) {
			if (!vis[i][n - 1] && grid[i][n - 1] == 1) {
				dfs(grid, vis, m, n, i, n - 1);
			}
			i++;
		}
//    Up left to right
		i = 0;
		while (i < n) {
			if (!vis[0][i] && grid[0][i] == 1) {
				dfs(grid, vis, m, n, 0, i);
			}
			i++;
		}
		
		
		
		
		i=0;
		for(i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				if(!vis[i][j] && grid[i][j]==1) {
//					System.out.println(i+" "+j);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int grid[][] = {{0, 0, 0, 1},
			            {0, 1, 1, 0},
			            {0, 1, 1, 0},
			            {0, 0, 0, 1},
			            {0, 1, 1, 0}};
		int count = numberOfEnclaves(grid);
		System.out.println(count);

	}
}
