package LeetCode;

import java.util.PriorityQueue;

public class KthLargestElement {
	public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for(int i:nums){
        	pq.add((long) i);
        	if(pq.size()>k){
                pq.poll();
            }
            System.out.println(pq);
        }
        long i = pq.peek();
        return (int) i;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {2,1,4,3,5};
		int k=2;
		System.out.println(findKthLargest(nums, k));
		
	}
}
