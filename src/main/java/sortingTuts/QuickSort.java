package sortingTuts;

public class QuickSort {
	
	public static int sort(int[] arr, int low, int high) {
		System.out.println("Low :- "+low+" high:- "+high);
		int pivot = (low+high)/2;
		int i=0;
		int j=high;
		
		while(i<j) {
			System.out.println("i:- "+i+" j:- "+j+" pivot:- "+pivot);
			while(arr[i]<=arr[pivot] && i<=high) {
				i++;
			}
			while(j>low && arr[j]>arr[pivot]) {
				j--;
			}
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
		int temp = arr[pivot];
		arr[pivot] = arr[j];
		arr[j] = temp;
		
		return i;
	}
	
	public static void qs(int[] arr,int low,int high) {
		
		if(low<high) {
			int pivot = sort(arr,low,high);
			System.out.println("Pivot:-"+pivot);
			qs(arr,low,pivot-1);
			qs(arr, pivot+1, high);
		}
	}
	public static void main(String[] args) {
		int arr[] = {4,6,2,5,7,9,1,3};
		qs(arr,0,arr.length-1);
		for(int e:arr) {
			System.out.print(e+" ");
		}
	}
}
