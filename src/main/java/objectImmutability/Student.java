package objectImmutability;

import java.util.ArrayList;
import java.util.List;

final public class Student {
	final private int id;
	final private String name;
	final private int age;
	final private List<String> friends;

	public Student(int id, String name, int age, List<String> friends) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;

		List<String> temp = new ArrayList<String>();

		friends.forEach(item -> temp.add(item));
		this.friends = temp;

	}

	public List<String> getFriends() {
		List<String> temp = new ArrayList<String>();

		friends.forEach(item -> temp.add(item));
		return temp;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", friends=" + friends + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
