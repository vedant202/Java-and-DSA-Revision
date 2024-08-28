package GraphsDS;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfIslands {
	
	static void dfs(char[][] grid,boolean[][] vis,int r,int c) {
		if(r>=grid.length || c>=grid[0].length || r<0 || c<0 || vis[r][c]==true || grid[r][c]=='0') {
			return;
		}
		vis[r][c] = true;
		dfs(grid, vis, r+1, c);
		dfs(grid, vis, r-1, c);
		dfs(grid, vis, r, c+1);
		dfs(grid, vis, r, c-1);
		dfs(grid, vis, r+1, c+1);
		dfs(grid, vis, r-1, c-1);
		dfs(grid, vis, r-1, c+1);
		dfs(grid, vis, r+1, c-1);
		
	}
	
	static int NoOfIsland(char[][] grid) {
		int r =grid.length;
		int c = grid[0].length;
		boolean[][] vis = new boolean[r][c];
		
		int islands = 0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!vis[i][j] && grid[i][j]=='1') {
					islands++;
					dfs(grid,vis,i,j);
				}else {
					vis[i][j]=true;
				}
			}
		}
		
		return islands;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows");
		int m = sc.nextInt();
		System.out.println("Enter no of cols");
		int n = sc.nextInt();
		
		char grid[][] = new char[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				char u= sc.next().charAt(0);
				grid[i][j]=u;
			}
			
		}
		
		for(var i:grid) {
			System.out.println(Arrays.toString(i));
		}
		
		int islands = NoOfIsland(grid);
		System.out.println(islands);
	}
}
