package Problemes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPermutationArray {
	
	static void helper(List<Integer> arr,int idx,List<List<Integer> > ans){
		
		if(idx==arr.size()) {
			List<Integer>temp = new ArrayList<Integer>();
			
			for(int i:arr) {
				temp.add(i);
			}
			ans.add(temp);
			return;
		}
		
		for(int i=idx;i<arr.size();i++) {
			Collections.swap(arr, idx, i);
			helper(arr, idx+1, ans);
			Collections.swap(arr, idx, i);
		}
		return ;
	}
	
	static List<List<Integer> > permutation(List<Integer> arr) {
		
		
		List<List<Integer> > ans = new ArrayList();
		helper(arr,0,ans);
		return ans;
	}
	
	 public static void main(String[] args) {
		 List<Integer> arr= new ArrayList<Integer>();
		 arr.addAll(List.of(1,2,3));
		 
		 var ans = permutation(arr);
		 System.out.println(ans);
	}
}
