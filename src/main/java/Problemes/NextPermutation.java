package Problemes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class NextPermutation {
	public static void main(String[] args) {
//		int[] nums = {1,2,5,4,3,0,0};
		int[] nums = {1,1,5};
		int n = nums.length;
		int idx = -1;
		for(int i=n-2;i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				idx = i;
				break;
			}
		}
		if(idx==-1) {
			
			for(int i=0;i<n/2;i++) {
				int st = nums[i];
				nums[i] = nums[n-1-i];
				nums[n-1-i] = st;
				
			}
			
			
		}else {
			int gidx = -1;
			for(int i=n-1;i>=0;i--) {
				if(nums[i]>nums[idx]) {
					gidx = i;
					break;
				}
			}
			
			int temp = nums[gidx];
			nums[gidx] = nums[idx];
			nums[idx] = temp;
			
//			int[] arr = new int[n-idx];
			int sidx= n-1-idx;
			for(int i=n-1;i>idx && (n-1-idx)/2<sidx;i--) {
				int t = nums[i];
				nums[i] = nums[n-sidx];
				nums[n-sidx] = t;
				sidx--;
				
			}
		}
		
		
		
		System.out.println(Arrays.toString(nums));
		
		
	}
}
