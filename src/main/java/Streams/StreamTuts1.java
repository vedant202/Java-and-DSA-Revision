package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamTuts1 {
	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		
		for(long i=1;i<1000000;i++) {
			list.add(i);
		}
		// printing all the elements
//		list.stream().forEach(System.out::println);
		
		// adding all the even elements from the list
		 Long add =list.stream().filter(i->{
			if(i==1) return false;
			for(int j=2;j<i;j++) {
				if(i%j==0 ) {
					return false;
				}
				System.out.println("check prime :- "+i);
			}
			return true;
		}).mapToLong(i->i).sum();
		System.out.println(add);
		
	}
}
