/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringDS;


/**
 *
 * @author DELL
 */
public class StringQuestions {
    public static char toLowerCaseChar(char c){
        if(c>='a' && c<='z') return c;
        char temp=(char) (c-'A'+'a');
        return temp;
    }
    public static void reverse(char[] chArr){
        int left=0;
        int right = chArr.length-1;
        
        while(left<right){
            char temp = chArr[left];
            chArr[left] = chArr[right];
            chArr[right] = temp;
            left++;
            right--;
        }
    }
    public static boolean  checkPalindrome(char[] chArr){
        int left = 0;
        int right = chArr.length-1;
       
        while(left<=right){
            if(chArr[left]!=chArr[right]){
                return false;
                
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static String removeCharAt(String str){
        int idx = str.indexOf('n');
        return str.substring(0,idx) + str.substring(idx+1,str.length());
    }
    public static void main(String[] args){
        String str = "Vedant";
        
        char[] chArr = str.toCharArray();
//        System.out.println(chArr);
//        reverse(chArr);
//        for(char c:chArr){
//            System.out.print(c);
//        }

        boolean checkPalindrome = checkPalindrome(chArr);
        System.out.println(checkPalindrome);
        
        System.out.println("B to lower case "+toLowerCaseChar('z'));
        
        String temp="h";
        System.out.println(temp.length());
        
//        System.out.println(str.);
        String newStr = removeCharAt(str);
        System.out.println("New string "+newStr);
    }
}
