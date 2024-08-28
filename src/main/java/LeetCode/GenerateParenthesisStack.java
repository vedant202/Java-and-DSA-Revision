package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 22. Generate Parentheses Leetcode
public class GenerateParenthesisStack {
	
	public static void backTrack(List<String> res,Stack<String> stack,int n,int openN,int closeN) {
		if((openN==closeN) && (openN==n && closeN==n)) {
			res.add("".join("", stack.stream().toList()));
			return;
		}
		if(openN<n) {
			stack.push("(");
			backTrack(res, stack, n, openN+1, closeN);
			stack.pop();
		}
		if(closeN<openN) {
			stack.push(")");
			backTrack(res, stack, n, openN, closeN+1);
			stack.pop();
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		backTrack(res,stack,n,0,0);
		return res;
    }
	
	public static void main(String[] args) {
		int n=3;
//		Stack<String> stack = new Stack<String>();
//		stack.add("(");
//		stack.add(")");
//		
//		System.out.println("".join("", stack.stream().toList()));
		
		List<String> res = generateParenthesis(n);
		System.out.println(res);
			
		
	}
}
