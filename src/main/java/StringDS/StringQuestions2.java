/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringDS;

import java.util.HashMap;

/**
 * 
 * @author DELL
 */
public class StringQuestions2 {
    // Max occurence of char in string
    public static void maxCharArray(char[] c,HashMap<Character,Integer> map){
        for(int i=0;i<c.length;i++){
            if(map.get(c[i])!=null)
            {
                
                int count = map.get(c[i]).intValue();
                count +=1;
                map.put(c[i], count);
            }else{
                map.put(c[i], 1);
            }    
        }
    }
    // Max occurence of char in string
    public static void maxCharArray2(String str){
        int[] arr = new int[26]; 
        for(int i=0;i<str.length();i++){
            int number = 0;
            number = str.charAt(i) -'a';
            arr[number]++;
        }
        int maxi = -1;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(maxi<arr[i]){
                maxi = arr[i];
                ans = i;
            }
        }
        char maxOccurences = (char)(ans+'a');
        System.out.println("Max occurenses of character is "+maxOccurences);
    }
    
    //Reverse a string
    public static void reverse(char[] temp){
        int left=0;
        int right = temp.length-1;
        
        while(left<right){
            char t = temp[left];
            temp[left] = temp[right];
            temp[right] = t;
            left++;
            right--;
        }
    }
     //Reverse a word separated by char in string
    public static void reverseWordString(char[] charArr){
        
        
        String tempStr ="";
        String finalStr="";
        
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]!=' '){
                tempStr+=charArr[i];
                
            }
            if(charArr[i]==' ' || i== charArr.length-1){
                
                char[] temp = tempStr.toCharArray();
                
                reverse(temp);
                
//                System.out.println(temp);
                
                for(int j=0;j<temp.length;j++){
                    finalStr += temp[j];
                }
                finalStr +=' ';
                
                tempStr = "";
                
            }
            
            
        }
        System.out.println("End " + finalStr);
        
        for(int i=0;i<charArr.length;i++){
            charArr[i] = finalStr.toCharArray()[i];
        }
    }
    
    // removes all occurences of substring
    public static String removeOccurences(String s,String subStr){
        while(s.length()!=0 && s.contains(subStr)){
//            int idx = s.indexOf(subStr);
            s =s.replaceFirst(subStr, "");
        }
        return s;
    }
    // replace character white another character
    public static String replaceChar(String s,char charToReplace,String c){
        String temp = "";
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == charToReplace){
                temp+=c;
            }
            else{
                temp+=s.charAt(i);
            }
        }
        return temp;
    }
    
    public static boolean containsPrmutations(String s1,String s2){
        int arr[] = new int[26];
        
        for(int i=0;i<s2.length();i++){
            arr[s2.charAt(i)-'a'] = 1;
        }
        
        int i=0;
        int j=1;
        while(i<j && j<s1.length()){
            arr[s1.charAt(i)-'a']++;
            arr[s1.charAt(j)-'a']++;
            i++;
            j++;
        }
        i=0;
        
        for(i=0;i<s2.length();i++){
            if(arr[s2.charAt(i)-'a']<=1){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        String str = "My name is vedant";
        
        // Reverse a string
        char[] charArr = str.toCharArray();
        reverseWordString(charArr);
        for(char i:charArr){
            System.out.print(i);
        }
        System.out.println();
        
        
        // max occurences in string
        String s2 = "testsamplee";
        char[] s2Arr = s2.toCharArray();
        
        HashMap<Character,Integer> map = new HashMap<>();
        maxCharArray(s2Arr,map);
        int max=0;
        char c='0';
//        map.forEach((k,v)->{
//            
//           
//            System.out.println(k +" :- "+v);
//        });
        for(var i:map.entrySet()){
            if(max<i.getValue()){
                max = i.getValue();
                c = i.getKey();
            }
            System.out.println(i);
        }
        System.out.println(c+" "+max);
        
        maxCharArray2(s2);
        
        
        //replace character white another character
        String s3 = "My name is vedant";
//        s3 = s3.replace(" ", "@40");
        s3 = replaceChar(s3,' ',"@40");
        System.out.println(s3);
        
        
         // removes all occurences of substring
        String s4 = "daabcbaabcbc";
        String sub = "abc";
        s4 = removeOccurences(s4,sub);
        System.out.println(s4);
        
        //Checking permutations of String
        String s5 ="eidbaabooo";
        String s6 = "ab";
        boolean check = containsPrmutations(s5,s6);
        System.out.println("String contains palindrome true or flase :-"+check);
        
    }
}
