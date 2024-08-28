package Problemes;

public class kandensAlgorithm {
	
	public static int maxSubArraySum(int[] arr) {
		int n = arr.length;
		
		int sum =arr[0];
		
		for(int i=0;i<n;i++) {
			int temp = arr[i];
			for(int j=i;j<n;j++) {
				if(i!=j) {
					temp = temp+arr[j];
				}
				
				sum = Math.max(temp, sum);
			}
		}
		
		return sum;
	}
	public static int kadanesAlgo(int[] arr,int n) {
		int max = Integer.MIN_VALUE;
		int sum =0;
		for(int i=0;i<n;i++) {
			sum = sum + arr[i];
			
			max = Integer.max(max, sum);
			if(sum<0) {
				sum = 0;
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
//		int[] arr = {-3 ,-5 ,-6};
//		int sum = maxSubArraySum(arr);
		int sum = kadanesAlgo(arr, arr.length);
		System.out.println(sum);
	}
	
}
