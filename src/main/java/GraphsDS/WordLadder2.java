package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.geeksforgeeks.org/problems/word-ladder-ii/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder-ii
public class WordLadder2 {
	
	public static ArrayList<ArrayList<String>> findSequences(String startWord,
            String targetWord,
            String[] wordList) {
		// Code here
		Queue<ArrayList<String>> que = new LinkedList<ArrayList<String>>();
		Set<String> set = new HashSet<String>();
		
		for(String i:wordList) {
			set.add(i);
		}
		System.out.println(set);
		ArrayList<String> t = new ArrayList<String>();
		t.add(startWord);
		que.add(t);
		
		ArrayList<String> usedOnLevel = new ArrayList<String>();
		usedOnLevel.add(startWord);
		int level = 0;
		
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		
		while(!que.isEmpty()) {
			ArrayList<String> vec =que.peek();
			
			que.poll();
//			System.out.println(word);
			if(vec.size()>level) {
				level++;
				for(String it: usedOnLevel) {
					set.remove(it);
				}
			}
			
			String word = vec.get(vec.size()-1);
//			System.out.println(word+" "+set+" ans:- "+ans);
			if(word.equals(targetWord)) {
				if(ans.size()==0) ans.add(vec);
				else if(ans.get(0).size()==vec.size()) ans.add(vec);
			}
			
			for(int i=0;i<word.length();i++) {
				
				for(char j='a';j<'z';j++) {
					char[] wordArr = word.toCharArray();
					wordArr[i] = j;
					String nWord = new String(wordArr);
					if(set.contains(nWord)== true) {
						System.out.println(nWord+" :- "+set);
						vec.add(nWord);
						ArrayList<String> temp = new ArrayList<String>(vec);
						que.add(temp);
						usedOnLevel.add(nWord);
						vec.remove(vec.size()-1);
						
					}
				}
			}
			
			
		}
		
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		String[] wordList = {"ab","cb","cz"};
		String startWord = "ab", targetWord= "cz";
		
		System.out.println(findSequences(startWord, targetWord, wordList));
		
	}
}
