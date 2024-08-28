package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		int[] res = new int[nums1.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums2.length;i++) {
			map.put(nums2[i], i);
		}
		Arrays.fill(res, -1);
		
		
		for(int i=0;i<nums1.length;i++) {
			for(int j=map.get(nums1[i]);j<nums2.length;j++) {
				
				if(nums1[i]<nums2[j]) {
					res[i] = nums2[j];
					break;
					
				}
				
			}
			
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		
		int[] res = nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.stream(res).boxed().toList());
	}
}
