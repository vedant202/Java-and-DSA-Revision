package LambdaExpressions;

public class Main {
	public static void main(String[] args) {
		InterSum a = (i,j)->{return (i+j);};
		int res = a.add(1, 2);
		
		System.out.println(res);
	}
}
