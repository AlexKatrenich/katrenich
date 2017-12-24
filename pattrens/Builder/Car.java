package katrenich.pattrens.Builder;

public class Car {
	String make;
	Transmission transmision;
	int maxSpeed;

	public void setMake(String make) {
		this.make = make;
	}
	public void setTransmission(Transmission transmision) {
		this.transmision = transmision;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car{" +
				"make='" + make + '\'' +
				", transmision=" + transmision +
				", maxSpeed=" + maxSpeed +
				'}';
	}
}
