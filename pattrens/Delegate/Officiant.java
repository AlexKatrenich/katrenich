package katrenich.pattrens.Delegate;

public class Officiant {
	private Cook cook;

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	public void cookDish(){
		cook.cookDish();
	}
}
