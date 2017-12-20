package katrenich.pattrens.FactoryMethod;


public class AppMain {
	public static void main(String[] args) {
		TelephoneMaker factory = getFactoryByName("samsung");
		factory.createPhone().call();
		factory = getFactoryByName("nokia");
		factory.createPhone().call();

	}

	private static TelephoneMaker getFactoryByName(String name){
		if(name != null){
			if(name.equals("samsung")){
				return new SamsungMaker();
			} else if (name.equals("nokia")){
				return new NokiaMaker();
			}
		}
		throw new RuntimeException("Не підтримується виробнича лінія телефонів" + name);
	}
}
