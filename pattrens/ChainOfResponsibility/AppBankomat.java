package katrenich.pattrens.ChainOfResponsibility;

public class AppBankomat {
	public static void main(String[] args) {
		//Створюються модулі банкомату з купюрами номіналом в 50, 100, 200, 500
		NoteModule n50 = new NoteModule50();
		NoteModule n100 = new NoteModule100();
		NoteModule n200 = new NoteModule200();
		NoteModule n500 = new NoteModule500();

		//Створюється зв'зок між модулями купюр - ссилки з модуля вищого розряду до нищого
		n500.setNextMoneyModule(n200);
		n200.setNextMoneyModule(n100);
		n100.setNextMoneyModule(n50);

		n500.takeMoney(new Money(1_950));



	}
}
