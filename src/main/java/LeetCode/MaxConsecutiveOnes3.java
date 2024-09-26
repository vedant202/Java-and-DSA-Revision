package LeetCode;

public class MaxConsecutiveOnes3 {
public static int longestOnes(int[] nums, int k) {
        int maxx = 0;
        int maxZero = 0;
        int l=0;
        for(int r=0;r<nums.length;r++) {
        	if(nums[r]==0) {
        		maxZero +=1;
        	}
        	
        	while(maxZero>k) {
        		if(nums[l]==0) {
        			maxZero -=1;
        			
        		}
        		l++;
        		
        	}
        	maxx = Math.max(r-l+1, maxx);
        }
        return maxx;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,1};
		int k=2;
		System.out.println(longestOnes(nums, k));
	}
}
