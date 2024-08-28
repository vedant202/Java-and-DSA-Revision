package Problemes;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
	
	public static boolean checkWord(String str,String fr,String lr, String mr ) {
		boolean  check = true;
		
		for(int i=0;i<str.length();i++) {
			if(!fr.contains(String.valueOf(Character.toLowerCase( str.charAt(i))))) {
				check = false;
			}
		}
		//if check is true in first row then return from here only
		if(check==true) {
			return check;
		}
		check=true;
		for(int i=0;i<str.length();i++) {
			if(!mr.contains(String.valueOf(Character.toLowerCase( str.charAt(i))))) {
				check = false;
			}
		}
		
		if(check==true) {
			return check;
		}
		
		check=true;
		for(int i=0;i<str.length();i++) {
			if(!lr.contains(String.valueOf(Character.toLowerCase( str.charAt(i))))) {
				check = false;
			}
		}
		
		return check;
	}
	
	public static String[] findWords(String[] words) {
		String fr = "qwertyuiop";
		String mr = "asdfghjkl";
		String lr = "zxcvbnm";
		
		
		
		List<String> res = new ArrayList<String>();
		
		for(String i:words) {
			boolean c = checkWord(i,fr,mr,lr);
			System.out.println(c+" "+i);
			if(c) {
				res.add(i);
			}
		}
		String k[] = res.toArray(new String[res.size()]);
		return k;
		
	}
	public static void main(String[] args) {
		String arr[] = {"Hello","Alaska","Dad","Peace"};
		findWords(arr);
		
		
	}
}
