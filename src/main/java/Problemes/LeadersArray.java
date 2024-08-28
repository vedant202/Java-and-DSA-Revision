package Problemes;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersArray {
	public static void main(String[] args) {
		int arr[] = {1,2,3,2,1,3};
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
//		for(int i=0;i<arr.length;i++) {
//			boolean check = true;
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[j]>=arr[i]) {
//					check = false;
//				}
//			}
//			if(check) {
//				
//				ans.add(arr[i]);
//				
//			}
//			
//		}
		
		int max = Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--) {
			if(max<arr[i]) {
				max = arr[i];
				ans.add(arr[i]);
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans);
	}
}
