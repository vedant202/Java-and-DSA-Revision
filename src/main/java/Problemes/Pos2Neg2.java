package Problemes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pos2Neg2 {
	
	public static void main(String[] args) {
		int[] arr = {2,1,-3,-4};
		System.out.println("wf.r.w.".replace(".","[.]"));
//		ArrayList<Integer> pos = new ArrayList<Integer>();
//		ArrayList<Integer> neg = new ArrayList<Integer>();
//		
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]<0) {
//				neg.add(arr[i]);
//			}else {
//				pos.add(arr[i]);
//			}
//		}
//		
//		for(int i=0;i<arr.length;i++) {
//			if(i%2==0) {
//				arr[i] = pos.get(i/2);
//			}else {
//				arr[i] = neg.get(i/2);
//			}
//		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=0 && i%2==0) {
				arr[i] = arr[i];
			}else {
				arr[i] =arr[i];
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
