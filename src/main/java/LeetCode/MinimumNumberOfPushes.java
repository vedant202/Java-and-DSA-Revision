package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumNumberOfPushes {
	
	static char getKeyFromMap(Map<Character,Long> charsmap,Long value){
		for(Map.Entry<Character,Long> i :charsmap.entrySet()) {
			if(i.getValue().equals(value)) {
				char c = i.getKey();
				charsmap.remove(i.getKey());
//				if(i.getValue()-1==0) {
//					
//				}else {
//					
//					charsmap.put(i.getKey(), i.getValue()-1);
//				}
				return c;
				
			}
			
		}
		return '0';
	}
	
	public static int minimumPushes(String word) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] keysMap = new String[8];
		Map<Character,Long> charsmap =word.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		System.out.println(charsmap);
		List<Long> sort = charsmap.values().stream().sorted((a,b)->(int)(b-a)).collect(Collectors.toList());
		int j=0;
//		int k = 0;
		System.out.println(sort);
		
		for(var i:sort) {
			char key = getKeyFromMap(charsmap, i);
			
			System.out.println(key+" : "+i);
			keysMap[(j%8)] = (keysMap[(j%8)]==null?"":keysMap[(j%8)])+key;
			j++;
//			k++;
		}
		System.out.println(Arrays.toString(keysMap));
		
		int pushes = 0;
		int count=0;
		for(int k=0;k<word.length();k++) {
			for(int x=0;x<keysMap.length;x++) {
				for(int y=0;keysMap[x]!=null&& y<keysMap[x].length();y++) {
					if(keysMap[x].contains(word.charAt(k)+"")) {
//						System.out.println(word.charAt(k)+" "+keysMap[x].charAt(y));
						pushes+=1;
						if(keysMap[x].charAt(y)==word.charAt(k)) {
							
							break;
						}
					}
					
				}
			}
		}
		System.out.println(count);
		System.out.println(pushes);
		return pushes;
	}
	
	public static void main(String[] args) {
		String word = "abcde";
		minimumPushes(word);
	}
}
