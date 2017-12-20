package katrenich.pattrens.FactoryMethod;


public class NokiaMaker implements TelephoneMaker {
	@Override
	public MobilePhone createPhone() {
		return new NokiaMobilePhone();
	}
}
