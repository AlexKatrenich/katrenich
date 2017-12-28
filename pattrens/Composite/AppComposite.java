package katrenich.pattrens.Composite;

public class AppComposite {
	public static void main(String[] args) {
		Mustang m1 = new Mustang();
		Mustang m2 = new Mustang();
		Subaru s1 = new Subaru();

		Kia k1 = new Kia();
		Mustang m3 = new Mustang();
		Subaru s2 = new Subaru();

		CompositeCar c1 = new CompositeCar();
		CompositeCar c2 = new CompositeCar();
		CompositeCar c3 = new CompositeCar();

		c2.addCar(m1);
		c2.addCar(m2);
		c2.addCar(s1);

		c1.addCar(k1);
		c1.addCar(m3);
		c1.addCar(s2);

		c3.addCar(c1);
		c3.addCar(c2);
		c3.addCar(new Kia());

		c3.drive();
	}
}
