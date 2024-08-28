package LeetCode;

//152. Maximum Product Subarray LeetCode
// 0*0,0*1,1
public class MaxProductSubArray {
	
	public static long maxProduct(int[] arr) {
		
		 long res = Long.MIN_VALUE;
	        
	        if(arr.length==1){
	            return arr[0];
	        }
			for(int i=0;i<arr.length;i++) {
				long temp = arr[i];
	            res = Math.max(temp, res);
				for(int j=i+1;j<arr.length;j++) {
					temp = temp*arr[j];
					res = Math.max(temp, res);
				}
				
				
			}
		
			return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,-3};
		long res = maxProduct(arr);
		System.out.println(res);
		int r = 1000000000;
		System.out.println(r);
	}
}
