/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision;
import com.VedantJavaRevision.printArray;
/**
 *
 * @author DELL
 */
public class OuickSortTut {
    static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int Partition(int l, int r,int[] arr){
        int n = arr.length;
        int pivot = arr[l];
        int i = l;
        int j = r;
        
        while(i<j){
            
            
            while(arr[i]<=pivot) i++;
            
            while(arr[j]>pivot) j--;
            
            if(i<j){
                swap(i, j, arr);
            }
            
        }
        swap(j, l, arr);
        
        return j;
    }
    
    static void QuickSort(int l,int r,int[] arr){
//        printArray printArr=new printArray();
        if(l<r){
            int piviot = Partition(l,r,arr);
            System.out.println("pivot "+piviot);
//            printArr.print(arr);
            QuickSort(l, piviot-1, arr);
            QuickSort(piviot+1, r, arr);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {4,6,2,5,7,9,1,3};
        int n = arr.length;
        printArray printArr = new printArray();
        
        QuickSort(0,n-1,arr);
        
        printArr.print(arr);
        
    }
}
