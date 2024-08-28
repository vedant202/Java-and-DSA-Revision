package Problemes;

import java.util.HashMap;
import java.util.Map;

public class sortArrayOand1 {
	public static void main(String[] args) {
		int[] arr = { 1,1,2,2, 0 };
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 0: {
				count0 += 1;
				break;
			}
			case 1: {
				count1 += 1;
				break;
			}
			case 2: {
				count2 += 1;
				break;
			}

			}
		}

		for (int i = 0; i < arr.length; i++) {
			if(count0>0) {
				count0--;
				arr[i] = 0;
			}else if(count1>0){
				count1--;
				arr[i] = 1;
			}else {
				count2--;
				arr[i] = 2;
			}
		}
		
		for(int i:arr) {
			System.out.print(i + " ");
		}

	}
}
