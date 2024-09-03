package GraphsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionaryTopologicalSort {
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
		int inDegree[] = new int[V];
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				inDegree[adj.get(i).get(j)]++;
			}
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				que.add(i);
			}
		}
		int[] res = new int[V];
		int i=0;
		while(!que.isEmpty()) {
			int node = que.poll();
			res[i++] = node;
			for(int it:adj.get(node)) {
				inDegree[it]--;
				if(inDegree[it]==0) {
					que.add(it);
				}
			}
		}
		return res;
		
    }
	
	public static String findOrder(String[] dict, int n, int k) {
        // Write your code here
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<k;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<n-1;i++) {
			String str1 = dict[i];
			String str2 = dict[i+1];
			int len = Math.min(str1.length(), str2.length());
			
			for(int ptr=0;ptr<len;ptr++) {
				if(str1.charAt(ptr) != str2.charAt(ptr)) {
					adj.get(str1.charAt(ptr)-'a').add(str2.charAt(ptr)-'a');
//					System.out.println(str1.charAt(ptr)+" "+str2.charAt(ptr));
					break;
				}
			}
			
		}
		
		int[] res = topoSort(k, adj);
		String str = "";
		for(int i=0;i<res.length;i++) {
//			System.out.println(res[i]);
			str=str+(char) (res[i]+(int)'a');
		}
		
		return str;
    }
	
	public static void main(String[] args) {
		String[] dict = {"baa","abcd","abca","cab","cad"};
		String res = findOrder(dict, 5, 4);
		System.out.println(res);
	}
}
