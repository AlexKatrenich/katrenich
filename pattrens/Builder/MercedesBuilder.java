package katrenich.pattrens.Builder;

public class MercedesBuilder extends CarBuilder {

	@Override
	void buildTransmission() {
		this.car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildMake() {
		this.car.setMake("Mercedes");
	}

	@Override
	void buildMaxSpeed() {
		this.car.setMaxSpeed(320);
	}
}
