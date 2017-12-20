package katrenich.pattrens.FactoryMethod;


public class AppMain {
	public static void main(String[] args) {
		MobileFactory factory = getFactoryByName("samsung");
		factory.createPhone().call();
		factory = getFactoryByName("nokia");
		factory.createPhone().call();

	}


	private static MobileFactory getFactoryByName(String name){
		if(name != null){
			if(name.equals("samsung")){
				return new SamsungFactory();
			} else if (name.equals("nokia")){
				return new NokiaFactory();
			}
		}
		throw new RuntimeException("Не підтримується виробнича лінія телефонів" + name);
	}
}
