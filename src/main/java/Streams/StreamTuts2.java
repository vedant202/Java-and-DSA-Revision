package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTuts2 {
	public static void main(String[] args) {
		
		String str = "abacbdfgjjk";
		
	
		Map<String, Long> strMap=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		List<String> strDistinct = Arrays.stream(str.split("")).distinct().collect(Collectors.toList());
		 Optional<Long> max=Arrays.stream(str.split("")).collect(Collectors.groupingBy(j->j,Collectors.counting())).values().stream().max((a,b)->a.intValue()-b.intValue());//		System.out.println(Arrays.stream(str.split("")).map(Function.identity()).count());
		
		 for(Map.Entry<String,Long> entry:strMap.entrySet()) {
			 if(entry.getValue()==max.get()) {
				 System.out.println(entry.getKey());
			 }
		 }
		 
		 System.out.println(strMap);
		System.out.println(strDistinct);
		System.out.println(max.get());
	}
}
