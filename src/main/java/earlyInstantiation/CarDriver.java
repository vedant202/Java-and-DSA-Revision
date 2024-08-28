package earlyInstantiation;

public class CarDriver {
	public static void main(String[] args) {
		Car c = new Car("Buggati Chiron", 380, "black",new Engine(2000, 200));
		System.out.println(c.e.hp);
	}
}
