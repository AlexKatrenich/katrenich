package katrenich.pattrens.Builder;

public class SubaruBuilder extends CarBuilder {

	@Override
	void buildTransmission() {
		this.car.setTransmission(Transmission.MANUAL);
	}

	@Override
	void buildMake() {
		this.car.setMake("Subaru");
	}

	@Override
	void buildMaxSpeed() {
		this.car.setMaxSpeed(290);
	}
}
