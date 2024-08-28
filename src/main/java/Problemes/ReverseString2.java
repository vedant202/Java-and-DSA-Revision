package Problemes;

public class ReverseString2 {
	public static void reverse(char [] arr,int i, int j) {
		j=j-1;
		while(i<j) {
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
			
		}
	}
	public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i+=2*k) {
        	System.out.println(i+" "+(i+k));
        		reverse(arr,i,Math.min(s.length(),i+k));
        }
        
        return new String(arr);
    }
	public static void main(String[] args) {
		String s = "abcd";
		String res = reverseStr(s, 2);
		System.out.println(res);
//		StringBuilder sb = new StringBuilder();
//        ;
	}
}
//bacdfeg
