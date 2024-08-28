package LeetCode;

import java.util.Arrays;
import java.util.Stack;

// Asteroid Collision - Stack - Leetcode 735
public class AsteroidCollisionStack {
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<asteroids.length;i++) {
			int aste = asteroids[i];
			System.out.println(stack+" "+aste);
			if(!stack.isEmpty()) {
				if(stack.peek()<0) {
					stack.push(aste);
					continue;
				}
				
				if(stack.peek()>0 && aste<0 && stack.peek()==Math.abs(aste)) {
					stack.pop();
					continue;
				}
				
				if(stack.peek()>0 && aste<0 && stack.peek()<Math.abs(aste)) {
					int lp = -1000;
                    while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(aste)) {
						lp = stack.pop();
					}
                    if(!stack.isEmpty() && stack.peek()>0 && stack.peek()==Math.abs(aste)){
                    	stack.pop();
                    	continue;
                    }

					if(!stack.isEmpty() && stack.peek()<Math.abs(aste)) {
						stack.push(aste);
					}else if(stack.isEmpty() && lp != Math.abs(aste)){
                        stack.push(aste);
                    }
					continue;
				}
				if(stack.peek()>0 && aste>0) {
					stack.push(aste);
				}
			}else {
				stack.push(aste);
			}
			
		}
		
		
		
		int res[] = new int[stack.size()];
		int i=0;
//		System.out.println(stack);
		while(!stack.isEmpty() && i<stack.size()) {
			
			res[i] = stack.elementAt(i);
			i++;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int asteroids[] = {-2,2,1,-2};
		System.out.println(Arrays.toString(asteroidCollision(asteroids))); 
		
	}
}
