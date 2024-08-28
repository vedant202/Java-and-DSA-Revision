package com.VedantJavaRevision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Comp implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		System.out.println("compare");
		return o1-o2;
	}
}

public class MergeSort {
	
	public static void mergeSort(int[] arr) {
		if(arr.length<=1) {
			return;
		}
		int mid = arr.length/2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(arr,left,right);
	}
	
	
	public static void merge(int[] arr,int[] left,int[] right) {
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length) {
			

			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i++;
				
			}else {
				arr[k] = right[j];
				j++;
			}
			
			k++;
			
		}
		while(i<left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,4};
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		mergeSort(arr);
		Arrays.stream(arr).forEach(System.out::print);
	}
	
}
