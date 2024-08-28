package com.VedantJavaRevision.SearchingAlgorithTuts;

public class BinarySearchAlgo2 {
	public static int bs(int[] arr,int l,int h,int ele) {
		int m = (l+h)/2;
		
		if(l>=h) {
			return -1;
		}
		
		if(arr[m]==ele) {
			return m;
		}
		
		if(ele<arr[m]) {
			return bs(arr,l,m,ele);
		}
		
		return bs(arr,m+1,h,ele);
		
		
	}
	
	public static int binarySearch(int[] arr,int ele) {
		int indx = bs(arr,0,arr.length-1,ele);
		
		return indx;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		
		int idx = binarySearch(arr, 9);
		System.out.println(idx);
	}
}
