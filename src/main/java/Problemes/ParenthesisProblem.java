/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problemes;

/**
 *
 * @author DELL
 */

import java.util.HashMap;
import java.util.Stack;
public class ParenthesisProblem {
    static Stack<Character> stack = new Stack<>();
    
    public static boolean checkParenthesis(String parenthesis){
        
        boolean check = false;
        HashMap<Character,Character> paren = new HashMap<>();
        paren.put('(', ')');
        paren.put('[', ']');
        paren.put('{', '}');
//        System.out.println(paren.keySet().contains('('));
        if(parenthesis.isBlank()){
            check=true;
            return check;
        }
        for(int i=0;i<parenthesis.length();i++){
            if(paren.keySet().contains(parenthesis.charAt(i))){
                stack.push(parenthesis.charAt(i));
            }
            else if(paren.values().contains(parenthesis.charAt(i))){
                if(stack.isEmpty()){
                    return false;
                }
                if(parenthesis.charAt(i) == ')'){
                    
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }
                else if(parenthesis.charAt(i) == ']'){
                    
                    if(stack.peek()=='['){
                        stack.pop();
                    }
                }
                else if(parenthesis.charAt(i) == '}'){
                    
                    if(stack.peek()=='{'){
                        stack.pop();
                    }
                }
            }
        }
        
        if(stack.isEmpty()) check=true;
        
        return check;
    }
    public static void main(String[] args) {
        String parenthesis = "[({})()]";
        boolean check = checkParenthesis(parenthesis);
        if(check){
            System.out.println("Parenthesis are valid");
        }
        else{
            System.out.println("Parenthesis are not valid");
        }
        stack.clear();
        
    }
    
}
