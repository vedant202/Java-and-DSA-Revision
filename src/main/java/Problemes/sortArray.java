/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problemes;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class sortArray {
    public static void bubbleSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static int removeDuplicatesArray(int[] arr,int n){
        if(n<=1){
            return n;
        }
        
        int temp[] = new int[n];
        int j = 0;
        for(int i=0;i<n-1;i++){
            if(arr[i] != arr[i+1]){
               temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        
        for(int i=0;i<j;i++){
            arr[i] = temp[i];
        }
        return j;
    }
   
    public static void printArray(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {2,5,7,9,2,3,5,5};
        int n = arr.length;
        
//        sort the array
        
//        bubbleSort(arr,n);
        Arrays.sort(arr);

//        for(int i:arr){
//            System.out.print(i+" ");
//        }
          // find duplicates in array
//        int countArrEle[] = new int[arr[arr.length-1]+1];
//        
//        for(int i=0;i<n;i++){
//            countArrEle[arr[i]]++;
//        }
//        
//        for(int i=0;i<n;i++){
//            if(countArrEle[i]>1){
//                System.out.println(i+" Repeated times :- "+countArrEle[i]);
//            }
//        }

        // Remove duplicates from array
        n = removeDuplicatesArray(arr,n);
        printArray(arr,n);
        
    }
}
