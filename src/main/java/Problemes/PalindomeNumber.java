package Problemes;

public class PalindomeNumber {
	public static void main(String[] args) {
		int a = 102;
		
		int b=0;
		int temp = a;
		while(temp>0) {
			b = b*10;
			int t = temp%10;
			b = b+t;
			temp = temp/10;
		}
		System.out.println(a+" "+b);
	}
}
