package katrenich.pattrens.Delegate;

public class App_Client {
	public static void main(String[] args) {
		Officiant officiant = new Officiant();
		officiant.setCook(new SalatCook());
		officiant.cookDish();

		officiant.setCook(new CocktailCook());
		officiant.cookDish();
	}
}
