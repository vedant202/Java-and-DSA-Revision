package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacterString {
	public static int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))!=null) {
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}else {
				map.put(s.charAt(i),1);
			}
		}
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
    }
	public static int firstUniqChar2(String s) {
		int arr[] = new int[26];
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	arr[c-'a']++;
        }
        
        for(int i=0;i<s.length();i++) {
        	if(arr[s.charAt(i)-'a']==1) {
        		return i;
        	}
        }
        
        
        return -1;
    }
	
	public static void main(String[] args) {
		String s = "ababdddbc";
//		ArrayList<Character> ch = new ArrayList<Character>();
//		ch.add('a');
//		ch.add('b');
//		ch.add('c');
//		ch.add('a');
//		System.out.println(ch);
//		ch.remove(Character.valueOf('b'));
//		System.out.println(ch);
//		System.out.println(s.);
		System.out.println(firstUniqChar2(s));
	}
}
