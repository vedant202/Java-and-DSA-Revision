/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.SearchingAlgorithTuts;



/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class findTripletsInArray {
    public static void main(String[] args) {
        int[] arr={2,1,3,4,6,5,8,7};
        
        HashSet<List<Integer>> ans_set = new HashSet<>();
        
        Arrays.sort(arr);
        for(int i:arr) System.out.println(i);
        
        int calc= 14;
        
        
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                for(int k=0;k<arr.length;k++){
//                    if(arr[i] + arr[j] +arr[k] == calc){
//                        ArrayList<Integer> ansList = new ArrayList<>();
//                        
//                        ansList.add(i);
//                        ansList.add(j);
//                        ansList.add(k);
//                        
//                        Collections.sort(ansList);
//                        ans_set.add(ansList);
//                    }
//                  
//                }
//            }
//        }
        
        for(int i=0;i<arr.length;i++){
            int res_calc = calc - arr[i];
            int j=i+1;
            int k =arr.length-1;
            
            while(j<k){
                
                
                if(arr[j] + arr[k]==res_calc ){
                    ArrayList<Integer> ansList = new ArrayList<>();
                    Collections.addAll(ansList, i,j,k);
                    Collections.sort(ansList);
                    ans_set.add(ansList);
                    j++;
                    k--;
                }
                else if(arr[j] + arr[k] < res_calc) j++;
                else if(arr[j] + arr[k] > res_calc) k--;
                
                
            }
        }
        
        for(var i :ans_set){
            System.out.println(i);
        }
        
//        System.out.println(arr);
    }
}
