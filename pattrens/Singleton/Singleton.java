package katrenich.pattrens.Singleton;



public class Singleton {
	public static int count = 0;
	private static volatile Singleton instance = null;
	private Singleton(){
		count++;
	}

	public static Singleton getInstance(){
		Singleton localInstance = instance;
		if(localInstance == null){
			synchronized (Singleton.class){
				localInstance = instance;
				if (localInstance == null){
					instance = localInstance = new Singleton();
				}
			}
		}
		return localInstance;
	}


}
