package katrenich.pattrens.FactoryMethod;


public class NokiaFactory implements MobileFactory {
	@Override
	public MobilePhone createPhone() {
		return new NokiaMobilePhone();
	}
}
