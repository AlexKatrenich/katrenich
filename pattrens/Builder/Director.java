package katrenich.pattrens.Builder;

public class Director {
	CarBuilder builder;

	void setBuilder(CarBuilder builder){
		this.builder = builder;
	}

	public Car buildCar(){
		builder.createCar();
		builder.buildMake();
		builder.buildTransmission();
		builder.buildMaxSpeed();
		return builder.getCar();
	}
}
