package LeetCode;

import java.util.Arrays;

public class RegionsCutBySlashes {
	static int regionsBySlashes(String[] grid) {
		int N = grid.length;
        int[][] newGrid  = new int[N*3][N*3];

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++) {
            	char ch = grid[r].charAt(c);
            	
            	if(ch=='/') {
            		newGrid[r*3][c*3+2] = 1;
            		newGrid[r*3+1][c*3+1]=1;
            		newGrid[r*3+2][c*3]=1;
            	}else if(ch=='\\') {
            		newGrid[r*3][c*3] = 1;
            		newGrid[r*3+1][c*3+1] = 1;
            		newGrid[r*3+2][c*3+2] = 1;
            		
            	}
            	
            	
            }
        }
        
        for(var i:newGrid) {
        	System.out.println(Arrays.toString(i));
        }
        
        int part = 0;
        for(int r=0;r<N*3;r++) {
        	for(int c=0;c<N*3;c++) {
        		if(newGrid[r][c]==0) {
        			part = part+1;
        			dfs(newGrid,r,c,N*3);
        		}
        	}
        }
        
        return part;
	}
	
	static void dfs(int[][] newGrid ,int r,int c,int l) {
		if(r<0 || c<0 || r>=l || c>=l || newGrid[r][c]==1  ) {
			return;
		}
		newGrid[r][c] = 1;
		dfs(newGrid, r, c+1, l);
		dfs(newGrid, r+1, c, l);
		dfs(newGrid, r, c-1, l);
		dfs(newGrid, r-1, c, l);
		
	}
	public static void main(String[] args) {
		String[] grid = {"/\\","\\/"};
		int part = regionsBySlashes(grid);
		System.out.println(part);
	}
}
