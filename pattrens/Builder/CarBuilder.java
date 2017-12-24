package katrenich.pattrens.Builder;

public abstract class CarBuilder {
	Car car;

	void createCar(){
		car = new Car();
	}

	abstract void buildTransmission();
	abstract void buildMake();
	abstract void buildMaxSpeed();

	Car getCar(){return car;}

}
