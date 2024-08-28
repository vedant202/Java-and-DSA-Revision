package LeetCode;

public class IntegerToEnglish2 {
	public static final int MIL = 1_000_000;
	public static final int BIL = 1_000_000_000;
	
	public static final String[] ones = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	public static final String[] tens = { "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	public static final String[] tensMulti = { "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Nintey" };

	private static StringBuilder stringBuilder;
	
	public static String numericToWords(int no) {
		stringBuilder = new StringBuilder();
		
		if(no==0) {
			stringBuilder.append("Zero");
		}
		
		makeNumber(no);
		
		return stringBuilder.toString().trim();
	}
	
	public static void makeNumber(int no) {
		if(no==0) {
			return;
		}else if(no<10) {
			stringBuilder.append(ones[no-1]).append(" ");
		}else if(no<20) {
			stringBuilder.append(tens[no%10]).append(" ");
		}else if(no<100) {
			stringBuilder.append(tensMulti[no/10-1]).append(" ");
			makeNumber(no%10);
		}
		else if(no<1000) {
			stringBuilder.append(ones[no/100-1]).append(" ");
			stringBuilder.append("Hundred ");
			makeNumber(no%100);
		}
		else if(no<MIL) {
//			999_999
			makeNumber(no/1000);
			stringBuilder.append("Thousand ");
			makeNumber(no%1000);
		}else if(no<BIL) {
			makeNumber(no/MIL);
			stringBuilder.append("Million ");
			makeNumber(no%MIL);
		}else{
			makeNumber(no/BIL);
			stringBuilder.append("Billion ");
			makeNumber(no%BIL);
		}
		
		
	}
	public static void main(String[] args) {
		
		int no = 100900009;
		String noInWords = numericToWords(no);
		System.out.println(noInWords);
	}
}
