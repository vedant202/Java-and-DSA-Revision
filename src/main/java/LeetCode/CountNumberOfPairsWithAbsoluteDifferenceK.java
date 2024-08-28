package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
	public static int countKDifference(int[] nums, int k) {
		int count=0;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(Math.abs(nums[i]-nums[j])==k) {
					count++;
				}
			}
		}
		
		return count;
    }
	
	public static int countKDifference2(int[] nums, int k) {
		int count=0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			count += map.getOrDefault(nums[i]+k, 0);
			count += map.getOrDefault(nums[i]-k, 0);
			
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		return count;
    }
	public static void main(String[] args) {
		
	}
}
