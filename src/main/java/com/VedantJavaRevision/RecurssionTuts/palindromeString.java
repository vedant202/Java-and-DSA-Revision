/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts;

/**
 *
 * @author DELL
 */
public class palindromeString {
    public static boolean checkPalindrome(String str,String rev_str,int n){
        if(n==-1) return str == rev_str;
        
        rev_str +=str.charAt(n);
        return checkPalindrome(str, rev_str, n-1);
    }
    public static boolean checkPalindrome(String str,int n){
        if(n==-1) return true;
        
        if(str.charAt((str.length()-1)%n)==str.charAt(n)){
            return checkPalindrome(str, n-1);
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "aba";
        
//        boolean check = checkPalindrome(str,"",str.length()-1);
        boolean check = checkPalindrome(str,str.length()-1);

        if(check){
            System.out.println("String is palindrome");
        }else{
            System.out.println("String is not palindrome");
        }
    }
}
