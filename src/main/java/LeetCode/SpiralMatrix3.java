package LeetCode;

import java.util.Arrays;

public class SpiralMatrix3 {
	
	static int[][] spiralMatrix(int rows,int cols,int rstart,int cstart){
		int total = rows*cols;
		int[][] res = new int[total][2];
		int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
		int d=0;
		int moves = 0;
		int x = rstart;
		int y= cstart;
		res[0] = new int[] {rstart,cstart};
		int i =1;
		
		System.out.println(x+" "+y);
		
		while(i<res.length) {
			int steps = (moves/2)+1;

			for(int j=0;j<steps;j++) {
				x += dirs[d][0];
				y += dirs[d][1];
				
				if(x>=0 && x<rows && y>=0 && y<cols) {
					
					res[i++] = new int[] {x,y};
				}
				
			}
			
			moves++;
			d = (d+1)%4;
		}
		
		
		return res;
		
	}
	
	public static void main(String[] args) {
		int rows = 5, cols = 6, rStart = 1, cStart = 4;
		
		int[][] res = spiralMatrix(rows,cols,rStart,cStart);
		for(var i:res) {
			System.out.println(Arrays.toString(i));
		}
		
	}
}
