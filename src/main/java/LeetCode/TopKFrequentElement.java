package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> charMap = new HashMap<Integer, Integer>();
		if(nums.length==1) {
			return nums;
		}
		for(int i:nums) {
			charMap.put(i, charMap.getOrDefault(i,0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>((i,j)->j.getValue()-i.getValue());
		pq.addAll(charMap.entrySet());
		
		System.out.println(pq);
		int ans[] = new int[k];
		int i=k;
		while(i>0) {
			ans[k-i] = pq.poll().getKey();
			i--;
		}
		return ans;
		
    }
	public static void main(String[] args) {
		int nums[] = {1}, k = 3;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));
	}
}
