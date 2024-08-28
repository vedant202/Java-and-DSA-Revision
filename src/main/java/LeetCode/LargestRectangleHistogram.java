package LeetCode;

import java.util.Stack;

public class LargestRectangleHistogram {
	public static void main(String[] args) {
		int[] heights = {2,4,2};
		int maxArea = 0;
		Stack<int[]> s = new Stack<int[]>();
		
		for(int i=0;i<heights.length;i++) {
			int start = i;
			while(!s.isEmpty() && s.peek()[1]>heights[i]) {
				int[] popArr = s.pop();
				maxArea = Math.max(maxArea, popArr[1]*(i-popArr[0]));
				start = popArr[0];
			}
			int[] temp = {start,heights[i]};
			s.add(temp);
			
		}
		for(int[] i: s) {
			maxArea = Math.max(maxArea, i[1] * (heights.length-i[0]));
		}
		System.out.println(maxArea);
		
	}
}
