/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision;

/**
 *Bubble Sort is the simplest sorting algorithm that works by repeatedly 
 * swapping the adjacent elements if they are in the wrong order
 * 
 * @author DELL
 */
public class BubbleSortTuts {
    public static void main(String[] args) {
        System.out.println("Bubble Sort");
        int arr[] = {4,3,7,1,5};
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                }
            }
        }
        
        for(int i:arr){
            System.out.println(i);
        }
            
        
    }
}
