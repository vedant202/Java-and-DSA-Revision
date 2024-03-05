package OptionalClassTuts;

import java.util.Optional;

public class OptionalExample {

	//	Simulated a database lookup
	public Optional<String> getNameById(int id) {
		if(id == 0) {
			return Optional.empty();
		}else {
			
			return Optional.ofNullable("Test");
		}
	}
	
	public static void main(String[] args) {
		
		OptionalExample optional = new OptionalExample();
		// Case 1:- if id greater than zero
		Optional<String> name =optional.getNameById(10);
		
		name.ifPresentOrElse((n)->{
			System.out.println("Name :- "+n);
		}, ()->{
			System.out.println("Username not found");
		});
		
		// Output :- Name :- Test 
		
		//Case 2:- if id is equal to zero
		
		name =optional.getNameById(11);
		name.ifPresentOrElse((n)->{
			System.out.println("Name :- "+n);
		}, ()->{
			System.out.println("Username not found");
		});
		
		// Output :- Username not found 
		
		// Using Maps
//		Case 1:- if id greater than zero
		name =optional.getNameById(10);
		name.map(n->n.toUpperCase()).ifPresentOrElse(System.out::println, ()->{
			System.out.println("Username not found");
		});
		
		// Output :- Name :- Test
		
		//Case 2:- if id is equal to zero
		name =optional.getNameById(0);
		name.map(n->n.toUpperCase()).ifPresentOrElse(System.out::println, ()->{
			System.out.println("Username not found");
		});
		// Output :- Username not found
	}
}
