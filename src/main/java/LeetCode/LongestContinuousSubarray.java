package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestContinuousSubarray {
	public static int longestSubarray(int[] nums, int limit) {
		
		List<List<Integer>> res = new ArrayList();
		
		for(int i=0;i<nums.length;i++) {
			
			for(int j=i;j<nums.length;j++) {
				int[] subArray = Arrays.copyOfRange(nums, i, j+1);
				List<Integer> temp = new ArrayList(); 
				
				for(int k:subArray) {
					temp.add(k);
				}
				res.add(temp);
			}
			
			
		}
		int size=0;
		for(int i=0;i<res.size();i++) {
			Comparator<Integer> comp = (a,b)->a-b;
			Integer min = res.get(i).stream().min(comp).get();
			Integer max = res.get(i).stream().max(comp).get();
			if(max-min<=limit && size<res.get(i).size()) {
				size=res.get(i).size();
			}
		}
		
		System.out.println(res);
        return size;
    }
	
	public static int longestSubarray2(int[] nums, int limit) {
		ArrayDeque<Integer> queue= new ArrayDeque<Integer>();
		int start=0;
		int end = 0;
		int size = 0;
	
		while(start<=end && end<nums.length) {
			int[] subArray = Arrays.copyOfRange(nums, start, end+1);
			int[] subArraySort = Arrays.stream(subArray).sorted().toArray();
			int min = subArraySort[0];
			int max = subArraySort[subArraySort.length-1];
			if(max-min<=limit) {
				size = Math.max(size, subArray.length);
				end++;
			}else {
				start++;
			}
			
		}
		
		return size;
	}
	
	public static int longestSubarray3(int[] nums, int limit) {
		
		ArrayDeque<Integer> increasing = new ArrayDeque<Integer>();
		ArrayDeque<Integer> decreasing = new ArrayDeque<Integer>();
		
		int left = 0;
		int res = 0;
		
		for(int right=0;right<nums.length;right++) {
			while (!increasing.isEmpty() && increasing.getLast()>nums[right]) {
				increasing.removeLast();
			}
			while(!decreasing.isEmpty() && decreasing.getLast()<nums[right]) {
				decreasing.removeLast();
			}
			
			increasing.add(nums[right]);
			decreasing.add(nums[right]);
			
			while(decreasing.getFirst()-increasing.getFirst()>limit) {
				if(decreasing.getFirst()==nums[left]) {
					decreasing.removeFirst();
				}
				if(increasing.getFirst()==nums[left]) {
					increasing.removeFirst();
				}
				left++;
			}
			
			res = Math.max(res, right-left+1);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {10,1,2,4,7,2};
		int size =longestSubarray3(nums, 5);
		System.out.println(size);
	}
}
