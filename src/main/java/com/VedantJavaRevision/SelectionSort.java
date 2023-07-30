package com.VedantJavaRevision;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * In selection sort algorithm, we search for the lowest element and arrange 
 * it to the proper location. We swap the current element with the next lowest number.
 * 
 * @author DELL
 */
public class SelectionSort {
    public static void main(String[] args) {
        
        int arr[] = {8,4,5,9,2};
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            
            for(int j=i+1;j<n;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    
}
