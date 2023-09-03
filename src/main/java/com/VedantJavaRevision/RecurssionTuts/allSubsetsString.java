/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts;

import java.util.HashSet;
import java.util.Iterator;


/**
 *
 * @author DELL
 */
public class allSubsetsString {
    public static String swap(String str,int a, int b){
        char[] str_arr = str.toCharArray();
        char temp = str_arr[a];
        str_arr[a] = str_arr[b];
        str_arr[b] = temp;
        
        String s = "";
        for(int i=0;i<str_arr.length;i++){
            s+=str_arr[i];
        }
//        System.out.pri+++++++++++++++++++ntln(s);
        return s;
        
        
    }
    public static void allSubsets(String str,HashSet<String> set,int index){
        if(index == str.length()){
            set.add(str);
            return;
        }
        
        for(int i=0;i<str.length();i++){
            str = swap(str,i,index);
//            System.out.println(str);
            allSubsets(str, set, index+1);
            str = swap(str,i,index);
        }
        
      
      
      
      
//        for(int i=0;i<str.length();i++){
//            
//
//        }
//        
    }
    
    public static void main(String[] args) {
        String str = "abc";
        HashSet<String> set = new HashSet<>();
        allSubsets(str,set,0);
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
    }
}
