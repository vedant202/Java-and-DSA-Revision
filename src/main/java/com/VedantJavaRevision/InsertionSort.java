/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision;

/**
 *
 * @author DELL
 */
public class InsertionSort {
    public static void main(String[] args) {
        
        System.out.println("Insertion Sort");
        int arr[] = {8,4,1,5,9,2};
        int n = arr.length;
        for(int i=1;i<n;i++){
            int temp = arr[i];
            
            int j=i-1;
            
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = temp;
            
        }
        
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
