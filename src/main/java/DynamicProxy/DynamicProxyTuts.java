package DynamicProxy;
import java.lang.reflect.Proxy;
import java.util.*;

public class DynamicProxyTuts{
	 public static void main(String[] args) {
	 	ObjectHandler objectHandler=new ObjectHandler(new HashMap<String,Integer>());
	 	
	 	Map<String,Integer> courses = (Map<String, Integer>) Proxy.newProxyInstance(
	 		HashMap.class.getClassLoader(),
	 		new Class[] {Map.class},
	 		objectHandler
	 	);

	 	courses.put("java",3000);
	 	courses.put("python",4000);
	 	System.out.println(courses);
	 }
}