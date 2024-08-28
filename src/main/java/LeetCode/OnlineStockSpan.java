package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {

	Stack<int[]> stack;
	
    public StockSpanner() {
        stack = new Stack<int[]>();
    }
    
    public int next(int price) {
    	int ans = 1;
    	//Monolithic decreasing stack
    	
    	while(!stack.isEmpty() && stack.peek()[0]<=price) {
    		ans = ans+stack.peek()[1];
    		stack.pop();
    	}
    	
    	int ele[] = {price,ans};
    	stack.add(ele);
    	
		return ans;
        
    }
}

public class OnlineStockSpan {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StockSpanner stockSpanner = new StockSpanner();
		arr.add(stockSpanner.next(100)); // return 1
		arr.add(stockSpanner.next(80)); 
		arr.add(stockSpanner.next(60)); 
		arr.add(stockSpanner.next(70)); 
		arr.add(stockSpanner.next(60)); 
		arr.add(stockSpanner.next(75));
		arr.add(stockSpanner.next(85)); 
		
		System.out.println(arr);
	}
}
