package GraphsDS;

import java.util.Arrays;

public class Replace0withX {
	
	
	static void dfs(char mat[][],boolean[][] vis ,int m ,int n, int r,int c) {
		if(r<0 || r>=m || c<0 || c>=n || vis[r][c] || mat[r][c]=='X') {
			return;
		}
//		System.out.println(r+" "+c);
		vis[r][c]=true;
		dfs(mat, vis, m, n, r-1, c);
		dfs(mat, vis, m, n, r+1, c);
		dfs(mat, vis, m, n, r, c-1);
		dfs(mat, vis, m, n, r, c+1);
	}
	
	static char[][] fill(int n, int m, char mat[][])
    {
		boolean[][] vis = new boolean[m][n];
		char newMat[][] =new char[m][n];
        // code here
		int i=0;
		while(i<n) {
			if(mat[0][i]=='O' && !vis[0][i]) {
				dfs(mat, vis, m, n, 0, i);
			}
			i++;
		}
		i=0;
		while(i<m) {
			if(mat[i][0]=='O' && !vis[i][0]) {
				dfs(mat, vis, m, n, i, 0);
			}
			i++;
		}
		
		i=0;
		while(i<n) {
			if(mat[m-1][i]=='O' && !vis[m-1][i]) {
				dfs(mat, vis, m, n, m-1, i);
			}
			i++;
		}
		
		i=0;
		while(i<m) {
			if(mat[i][n-1]=='O' && !vis[i][n-1]) {
				dfs(mat, vis, m, n, i, n-1);
			}
			i++;
		}
		
		for(int j=0;j<m;j++) {
			for(int k=0;k<n;k++) {
				newMat[j][k] = mat[j][k];
			}
		}
		
		i=0;
		for(i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!vis[i][j] && mat[i][j]=='O') {
					vis[i][j] = true;
					newMat[i][j] = 'X';
				}
			}
		}
		return newMat;
    }
	
//	https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
	public static void main(String[] args) {
		char[][] mat = {{'X', 'X', 'X', 'X'}, 
			       {'X', 'O', 'X', 'X'}, 
			       {'X', 'O', 'O', 'X'}, 
			       {'X', 'O', 'X', 'X'}, 
			       {'X', 'X', 'O', 'O'}};
		int m=5,n =4;
		
		for(var i:mat) {
			System.out.println(Arrays.toString(i));
		}
		
		char[][] newMat = fill(n, m, mat);
		System.out.println("----------------------------------");
		for(var i:newMat) {
			System.out.println(Arrays.toString(i));
		}
	}
}
