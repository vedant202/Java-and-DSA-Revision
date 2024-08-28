package Problemes;
// Find Majority Element
public class MooresVotingAlgo {
	public static int moresVoting(int[] arr) {
		int cnt = 0;
		int ele=-1;
		for(int i=0;i<arr.length;i++) {
			if(cnt==0) {
				ele = arr[i];
				cnt++;
			}else if(ele == arr[i]) {
				cnt++;
			}else {
				cnt--;
			}
		}
		
		int cnt2 =0;
		for(int i:arr) {
			if(i==ele) {
				cnt2++;
			}
		}
		if(cnt2>arr.length/2) {
			return ele;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 3, 1, 1, 3, 1, 1};
		int ele = moresVoting(arr);
		System.out.println(ele);
	}
}
