package merging;

public class mergingLists {
	public static void main(String[] args) {
		int arr[] = {2,10,18,20,23};
		int arr2[] = {4,9,19,25};
		
		int arr3[] = new int[arr.length+arr2.length];
		
		int l1 = arr.length,l2 = arr2.length;
		
		int i=0,j=0,k =0;
		
		while(i<l1 && j<l2) {
			if(arr[i]<arr2[j]) {
				arr3[k++] = arr[i++];
			}else {
				arr3[k++] = arr2[j++];				
			}
			
		}
		
		while(i<l1) {
			arr3[k++] = arr[i++];
		}
		
		while(j<l2) {
			arr3[k++] = arr2[j++];
			
		}
		
		for(int e:arr3) {
			System.out.print(e+" ");
		}
	}
}
