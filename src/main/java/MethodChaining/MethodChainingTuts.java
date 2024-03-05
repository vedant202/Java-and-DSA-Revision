package MethodChaining;

class Student{
	private String name;
	private int age;
	private String city;
	
	private Student() {}
	
	public static Student of() {
		return new Student();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Student setName(String name) {
		this.name=name;
		return this;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Student setAge(int age) {
		this.age=age;
		return this;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public Student setCity(String city) {
		this.city=city;
		return this;
	}
	
	
	
	public void print() {
		System.out.println( "Student [name=" + this.name + ", age=" + this.age + ", city=" + this.city + "]");
	}
	
	public String toString() {
		return "Student [name=\" + this.name + \", age=\" + this.age + \", city=\" + this.city + \"]";
	}
	
	
}

public class MethodChainingTuts {
	
	public static void main(String[] args) {
		Student
		.of()
		.setName("Vedant Dhenge")
		.setAge(20).setCity("Yavatmal")
		.print();
		
		
	}
}
