package GenericsTuts;

import java.util.ArrayList;
import java.util.List;





class Objects<T extends Object & Comparable<T>>{
	
	T obj;
	public Objects() {};
	public Objects(T obj) {
		this.obj = obj;
	}
	
	public List<T> sort(List<T> list) {
		for(int i=0;i<list.size();i++) {
			for(int j=i;j<list.size();j++) {
				if(list.get(i).compareTo(list.get(j))>0){
					T temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}

		return list;
	}
	
	public T getObj() {
		return this.obj;
	}
	
	public void quickSort(List<T> list) {
		
		
	}
}

public class Main {
	public static void main(String[] args) {
		
		
		
		long startTime = System.currentTimeMillis();
		List<Integer> listInt = List.of(10,20,6,4,3);
		Objects<Integer> intObject = new Objects<Integer>();
		List<Integer> temp = intObject.sort(new ArrayList<Integer>(listInt));
		System.out.println(temp);
		
		List<Double> listDouble = List.of(10.021,20.21,16.112,4.7,13.4);
		Objects<Double> doubleObject = new Objects<Double>();
		List<Double> temp1 = doubleObject.sort(new ArrayList<Double>(listDouble));
		System.out.println(temp1);
		
		List<String> listStrings = List.of("v","veda","ve","ved","vedant");
		Objects<String> stringObject = new Objects<String>();
		List<String> temp2 = stringObject.sort(new ArrayList<String>(listStrings));
		System.out.println(temp2);
		
		long endTime = System.currentTimeMillis();
		 // Calculate the elapsed time
        long elapsedTime = endTime - startTime;

        System.out.println("Time taken: " + elapsedTime + " milliseconds");
	}

}
