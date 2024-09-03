package GraphsDS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	static class Pair{
		String first;
		int second;
		public Pair(String first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
		
		
	}
	
	public static int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
		
		Queue<Pair> que = new LinkedList<WordLadder.Pair>();
		
		Set<String> set = new HashSet<String>();
		for(String i:wordList) {
			set.add(i);
		}
		
		que.add(new Pair(startWord, 1));
		set.remove(startWord);
		while(!que.isEmpty()) {
			Pair node = que.poll();
			int wt = node.second;
			String v = node.first;
			 
			boolean found = false;
			
			if(v.equals(targetWord)) {
				return wt;
			}
			
			
			for(int i=0;i<v.length();i++) {
				
				for(char j='a';j<='z';j++) {
					char arr[] =v.toCharArray();
					arr[i] = j;
					String ns= new String(arr);
//					System.out.println(ns);
					if(set.contains(ns)) {
						
						
						found=true;
						set.remove(ns);
						que.add(new Pair(ns, wt+1));
					}
//					System.out.println(que+" "+wt);
				}
				
				
			}
			
			
		}
		
		return 0;
		
    }
	public static void main(String[] args) {
		
		String[] wordList = {"des","der","dfr","dgt","dfs"};
		String startWord = "der", targetWord= "dfs";
		System.out.println(wordLadderLength(startWord, targetWord, wordList));
		
		
	}
}
