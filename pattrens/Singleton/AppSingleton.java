package katrenich.pattrens.Singleton;


public class AppSingleton {
	public static void main(String[] args) {
		Thread[] t = new Thread[10];

		for (Thread thread : t ) {
			new Thread(()->{
				Singleton singleton = Singleton.getInstance();
				System.out.println(Singleton.count);
			}).start();
		}

		System.out.println(Singleton.count);


	}

}
