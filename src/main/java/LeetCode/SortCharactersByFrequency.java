package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	public static String frequencySort(String s) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(char c :s.toCharArray()) {
        	charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        System.out.println(charMap);
        
        List<Map.Entry<Character, Integer>> entries = new ArrayList<Map.Entry<Character,Integer>>(charMap.entrySet());
        entries.sort((i,j)->j.getValue()-i.getValue());
        
        String newStr = "";
        
        for(var i:entries) {
        	for(int j=0;j<i.getValue();j++) {
        		newStr = newStr+i.getKey();
        	}
        }
        return newStr;
    }
	public static String frequencySort2(String s) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(char c :s.toCharArray()) {
        	charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
//        System.out.println(charMap);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((i,j)->j.getValue()-i.getValue());
        pq.addAll(charMap.entrySet());
        
        String newStr = "";
        
        while(!pq.isEmpty()) {
        	Map.Entry<Character, Integer> i = pq.poll();
        	for(int j=0;j<i.getValue();j++) {
        		newStr = newStr+i.getKey();
        	}
        }
        return newStr;
    }
	public static void main(String[] args) {
		String s = "Aabbccddde";
		System.out.println(frequencySort(s));
	}
}
