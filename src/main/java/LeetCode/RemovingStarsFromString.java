package LeetCode;

import java.util.Stack;

// 2390. Removing Stars From a String of leet code

public class RemovingStarsFromString {
	
	public static String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++) {
        	while(!stack.isEmpty() && s.charAt(i)=='*') {
        		stack.pop();
        		break;
        		
        	}
        	if(s.charAt(i)=='*') {
        		continue;
        	}
        	stack.add(s.charAt(i));
        }
        String res="";
        for(Character i:stack) {
        	res+=i;
        }
        return res;
    }
	
	public static String removeStars2(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='*') {
				sb.deleteCharAt(sb.length()-1);
			}else {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "leet**cod*e";
		String result=removeStars2(s);
		System.out.println(result);
	}
}
