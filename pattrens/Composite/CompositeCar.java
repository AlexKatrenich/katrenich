package katrenich.pattrens.Composite;

import java.util.ArrayList;

public class CompositeCar implements Car{
	private ArrayList<Car> cars;

	public CompositeCar(){
		cars = new ArrayList<>();
	}

	public void addCar(Car c){
		cars.add(c);
	}

	public void removeCar(Car c){
		cars.remove(c);
	}

	@Override
	public void drive() {
		for (Car car : cars){
			car.drive();
		}
	}
}
