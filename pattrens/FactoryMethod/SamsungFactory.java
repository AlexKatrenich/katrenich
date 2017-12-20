package katrenich.pattrens.FactoryMethod;


public class SamsungFactory implements MobileFactory {
	@Override
	public MobilePhone createPhone() {
		return new SumsungMobilePhone();
	}
}
