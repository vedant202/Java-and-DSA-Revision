/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.SearchingAlgorithTuts;

/**
 *
 * @author DELL
 */
public class BinarySearchAlgorithm {
    public static int BinarySearch(int[] arr,int ele,int l, int r){
        int mid = (l+r)/2;
        if(l>r){
            return -1;
        }
        
        if(ele<arr[mid]){
            return BinarySearch(arr, ele, l, mid-1);
            
        }
        if(ele>arr[mid]){
            return BinarySearch(arr, ele, mid+1, r);
            
        }
        return mid;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        
        int ele = BinarySearch(arr, 3, 0, n-1);
        System.out.println("Element index is "+ele);
        
        
    }
}
