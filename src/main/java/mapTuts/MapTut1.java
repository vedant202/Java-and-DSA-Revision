package mapTuts;

import java.util.Collections;
import java.util.HashMap;

public class MapTut1 {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(1, "Hello");
		hm.put(2,"Hii");
		hm.put(10.2, 'A');
		hm.put('A', "World");
		
		System.out.println(hm);
		System.out.println(hm.containsKey('A'));
		System.out.println(hm.containsValue("World"));
		System.out.println(hm.get(1));
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		
		hm.forEach((i,j)->{
			System.out.println(i+" :- "+j);
		});
		
		
	}
}
