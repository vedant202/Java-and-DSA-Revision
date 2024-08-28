package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	public static int[] dailyTemperatures(int[] temperatures) {
		
		int[] res = new int[temperatures.length];
		
		for(int i=0;i<temperatures.length;i++) {
			int count=1;
			for(int j=i+1;j<temperatures.length;j++) {
				if(temperatures[j]>temperatures[i]) {
					res[i] = count;
					break;
					
				}else {
					count++;
				}
			}
		}
		
		return res;
    }
	
	public static int[] dailyTemperatures2(int[] temperatures) {
//		Stack<Integer> stack = new Stack<Integer>();
//		int res[] = new int[temperatures.length];
//		
//		for(int i=0;i<temperatures.length;i++) {
//			if(!stack.isEmpty() && temperatures[stack.elementAt(stack.size()-1)]<temperatures[i]) {
//				res[stack.elementAt(stack.size()-1)] = i-stack.elementAt(stack.size()-1);
//				stack.removeElement(stack.elementAt(stack.size()-1));
//				while(!stack.isEmpty() && temperatures[stack.elementAt(stack.size()-1)]<temperatures[i]) {
//					res[stack.elementAt(stack.size()-1)] = i-stack.elementAt(stack.size()-1);
//					stack.removeElement(stack.elementAt(stack.size()-1));
//				}
//			}
//			
//			stack.add(i);
//		}
//		return res;
		
		Stack<Integer> stack = new Stack<Integer>();
		int res[] = new int[temperatures.length];
		
		for(int i=0;i<temperatures.length;i++) {
			while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
				int pop = stack.pop();
				res[pop] = i-pop;
			}
			
			
			stack.add(i);
		}
		return res;
    }
	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		int[] res = dailyTemperatures2(temperatures);
		Arrays.stream(res).forEach((i)->System.out.print(i+" "));
	}
}
