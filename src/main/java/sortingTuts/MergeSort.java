package sortingTuts;

import java.util.ArrayList;

public class MergeSort {

	public static void merge(int[] arr,int l, int mid, int h) {
		System.out.println("l :- "+l+" mid:- "+mid+" ,r:- "+h);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int left = l;
		int right = mid+1;
		while(left<=mid && right<=h) {
			if(arr[left]<arr[right]) {
				temp.add(arr[left++]);
			}else {
				temp.add(arr[right++]);
			}
		}
		while(left<=mid) {
			temp.add(arr[left++]);
		}
		while(right<=h){
			temp.add(arr[right++]);
		}
		for(int i=l;i<h;i++) {
			arr[i] = temp.get(i-l);
		}
		System.out.println(temp);
	}
	
	public static void mergeSort(int[] arr,int l,int r) {
		
		int mid=0;
		if(l<r) {
			mid = (l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr, mid+1, r);
			merge(arr,l,mid,r);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,1,6};
		
		mergeSort(arr,0,arr.length-1);
		
		for(int e:arr) {
			System.out.print(e+" ");
		}
	}

}
