package objectImmutability;

import java.util.ArrayList;
import java.util.List;

public class ObjectImmutability {
	public static void main(String[] args) {
		List<String> friList = new ArrayList<String>();
		friList.add("aryan");
		Student s = new Student(101,"vedant",23,friList);
		String name = s.getName();
		List<String> friends = s.getFriends();
		System.out.println(s);
		friends.add("sunny");
		System.out.println(s);
		
		
		
	}
}
