package mapTuts;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTut2 {
	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("vedant", 22);
		h.put("test", 23);
		h.put("test2", 21);
		h.put("test3", 20);
		
		System.out.println(h);
		
		System.out.println(h.getOrDefault("test4",0));
		
		for(Map.Entry<String,Integer> i: h.entrySet()) {
			System.out.println(i.getKey()+ " :- "+i.getValue());
			

		}
		
		System.out.println("=========================================");
		
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		lhm.put("test", 12);
		lhm.put("test1", 9);
		lhm.put("test2", 15);
		lhm.put("test3", 10);
		
		System.out.println(lhm);
		
		System.out.println("=========================================");
		System.out.println("Tree Map");
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		
		
		System.out.println(tm);
		
	}
}
