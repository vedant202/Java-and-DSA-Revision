/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts;

import java.util.HashSet;

/**
 *
 * @author DELL
 */
public class allSubsequenceString {
    public static void allSubsequence(String str,String curr,int index, HashSet<String> set){
        if(index==str.length()){
            set.add(curr);
            return;
        }
        
        allSubsequence(str, curr+str.charAt(index), index+1, set);
        allSubsequence(str, curr, index+1, set);
    }
    public static void main(String[] args) {
        String str = "abc";
        HashSet<String> set = new HashSet<>();
        allSubsequence(str,"",0,set);
        set.forEach((e)->{
            System.out.println(e);
        });
    }
}
