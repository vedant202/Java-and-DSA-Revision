package GraphsDS;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm


public class FlodFill {
	
	static void dfs(int[][] image,boolean[][] vis,int r,int c,int col,int itemToCol) {
		if(r<0 || c<0 || r>=image.length || c>= image[0].length || image[r][c]!=itemToCol || vis[r][c]==true ) {
			return;
		}
		System.out.println(r+" "+c);
		vis[r][c]=true;
		image[r][c] = col;
		dfs(image,vis, r+1, c, col,itemToCol);
		dfs(image,vis, r, c+1, col,itemToCol);
		dfs(image,vis, r, c-1, col,itemToCol);
		dfs(image,vis, r-1, c, col,itemToCol);
	}
	
	static void floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean[][] vis = new boolean[image.length][image[0].length];
		int itemToCol = image[sr][sc];
		dfs(image,vis,sr,sc,newColor,itemToCol);
	}
	
	public static void main(String[] args) {
		int[][] image = {
				{3,3,3},
				{4,3,0},
				{3,0,4}};
		
		int sr = 1;
		int sc=1;
		int newColor = 2;
		
		floodFill(image, sr, sc, newColor);
		
		for(var i:image) {
			System.out.println(Arrays.toString(i));
		}
	}
}
