package katrenich.pattrens.Builder;


public class App {
	public static void main(String[] args) {
		Director director = new Director();
		director.setBuilder(new MercedesBuilder());

		Car car = director.buildCar();
		System.out.println(car);
		director.setBuilder(new SubaruBuilder());
		System.out.println(director.buildCar());
	}
}
