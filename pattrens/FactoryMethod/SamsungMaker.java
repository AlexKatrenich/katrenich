package katrenich.pattrens.FactoryMethod;


public class SamsungMaker implements TelephoneMaker {
	@Override
	public MobilePhone createPhone() {
		return new SumsungMobilePhone();
	}
}
