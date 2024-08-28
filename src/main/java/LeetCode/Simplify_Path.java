package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class Simplify_Path {
	
	public static String simplifyPath(String path) {
Stack<String> stack = new Stack<String>();
		
		String[] arr = path.split("/");
		
		for(int i=0;i<arr.length;i++) {
			
				if(arr[i].equals("..") && !stack.isEmpty()) {
                    
                    stack.pop();
					
				}
                else if(!arr[i].isBlank() && !arr[i].equals(".") && !arr[i].equals("..")) {
                        stack.push(arr[i]);
                    }
			
		}
		String res = "";
        if(stack.isEmpty()){
            res = "/";
        }
		while(!stack.isEmpty()) {
			res = "/"+stack.pop()+res;
			
		}
        return res;
    }
	
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		
		System.out.println("checking res :- "+simplifyPath(path));
	}
}
