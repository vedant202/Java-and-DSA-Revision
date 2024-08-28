package Problemes;

import java.util.Arrays;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int arr[] = {5, 8, 3,4, 2, 1,8,9,12,11,10};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		int lcnt = -1;
		int cnt = 0;
		int lidx = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]-1==lidx) {
				cnt+=1;
				lidx=arr[i];
			}else if(arr[i]!=lidx){
				cnt = 1;
				lidx=arr[i];
			}
//			System.out.println(cnt);
			lcnt = Math.max(lcnt, cnt);
		}
		System.out.println(lcnt);
	}
}
