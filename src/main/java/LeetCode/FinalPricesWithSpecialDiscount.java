package LeetCode;

import java.util.Arrays;
import java.util.Stack;

// 1475. Final Prices With a Special Discount in a Shop of leetCode

public class FinalPricesWithSpecialDiscount {
	public static int[] finalPrices(int[] prices) {
		Stack<Integer> stack = new Stack();
		int[] res = new int[prices.length];
		for(int i=0;i<prices.length;i++) {
			while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]) {
				int pop = stack.pop();
				res[pop] = prices[pop]-prices[i];
				
			}
			stack.add(i);
		}
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			int pop = stack.pop();;
			res[pop] = prices[pop];
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		int[] prices = {8,4,6,2,3};
		int[] res =finalPrices(prices);
		
		Arrays.stream(res).forEach(System.out::println);
		
	}
}
