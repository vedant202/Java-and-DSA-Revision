package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWord {
	
	public static List<String> topKFrequentWord(String[] words,int k){
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		
		for(String i:words) {
			countMap.put(i, countMap.getOrDefault(i,0)+1);
		}
		
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>((i,j)->j.getValue()-i.getValue());
		pq.addAll(countMap.entrySet());
		List<String> ans = new ArrayList<String>();
		
		
		while(k>0) {
			ans.add(pq.poll().getKey());
			k--;
		}
		ans.sort((i,j)->i.charAt(0)-j.charAt(0));
		return ans;
		
	}
	
	public static void main(String[] args) {
		String words[] = {"i","love","leetcode","i","love","coding"};
		int  k = 2;
		
		System.out.println(topKFrequentWord(words,k));
	}
}
