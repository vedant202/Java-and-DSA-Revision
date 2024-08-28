package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;


public class SlidingWindoMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length-k+1];
		int j=0;
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0;i<nums.length;i++) {
			while(!queue.isEmpty() && nums[queue.getLast()]<nums[i]) {
				queue.removeLast();
			}
			queue.addLast(i);
			
			if(i-k==queue.getFirst()) {
				queue.removeFirst();
			}
			
			if(i>=k-1) {
				res[j++] = nums[queue.getFirst()];
			}
		}
		
		
		
        return res;
    }
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] res = maxSlidingWindow(nums, 3);
		List<Integer> list = Arrays.stream(res).boxed().toList();
		System.out.println(list);
		Arrays.stream(res).forEach(System.out::println);
	}
}
