package DynamicProxy;
import java.lang.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;


public class ObjectHandler implements InvocationHandler {

	Object object;

	public ObjectHandler(Object object){
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		
		
		if(method.getName().contains("put")) {
			
			
			if(args[0].equals("java")) {
				System.out.println("Invalid key : Java");
				Arrays.stream(args).forEach(System.out::println);
				return null;
			}
		}
		
		System.out.println("Before Object method call :- "+method.getName());
		Object invoke =method.invoke(object,args);
		System.out.println("After Object Handler");

		return invoke;

	}
}