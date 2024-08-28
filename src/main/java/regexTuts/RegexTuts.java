package regexTuts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTuts {
	
	public static int checkCondition(StringBuilder sb,int count) {
		String regex = ".*[a-z].*";
		 String regex2 = ".*[A-Z].*";
		 String regex3 = ".*[1-9].*";
		
			if(!Pattern.matches(regex, sb.toString())) {
				sb.append('a');
				count++;
			}
			if(!Pattern.matches(regex2, sb.toString())) {
				sb.append('A');
				count++;
			}
			if(!Pattern.matches(regex3, sb.toString())) {
				sb.append('1');
				count++;
			}
		return count;
	}
	
	public static int checkRepChar(StringBuilder sb) {
		int l=1;
//		int r=1;
		int rpc = 1;
		while(l<sb.length()) {
			if(sb.charAt(l-1)==sb.charAt(l)) {
				rpc++;
			}else {
				rpc = 1;
			}
			
			
			if(rpc>=3) {
				return l;
			}
			l++;
			
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		String str = "aaa123";
		StringBuilder sb = new StringBuilder(str);
		
		 
		 
	        
//        // Compile the regex pattern
//        Pattern pattern = Pattern.compile(regex3);
//        
//        // Create a matcher object
//        Matcher matcher = pattern.matcher(str);
//		
//		System.out.println(matcher.matches());
		 int count = 0;
		 count = checkCondition(sb, count);
//		 System.out.println(count);
		if(!(sb.length()>=6 && sb.length()<=20)) {
			
			
			
			for(int i=0;i<=6-sb.length();i++) {
				sb.append(Character.toChars((int)Math.random()*9));
				count++;
			}
			
			
		}
		int l=1;
//		int r=1;
		int rpc = 1;
		while(l<sb.length()) {
			if(sb.charAt(l-1)==sb.charAt(l)) {
				rpc++;
			}else {
				rpc = 1;
			}
			
			
			if(rpc>=3) {
				sb.deleteCharAt(l);
			}
			l++;
			
		}
		
		
		
		System.out.println(count);
		System.out.println(sb.toString());
	}
}
