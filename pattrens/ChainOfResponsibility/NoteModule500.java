package katrenich.pattrens.ChainOfResponsibility;

public class NoteModule500 extends NoteModule {

	@Override
	void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.U500;
		int reminder = money.getAmt()%Note.U500;

		if(countNote > 0){
			System.out.println("Видано: " + countNote + " купюр, номіналом - " + Note.U500);
		}
		if(reminder>0 && super.next!=null){
			super.next.takeMoney(new Money(reminder));
		} else {
			System.out.println("Залишилось: " + reminder + " не виданих коштів.");
		}
	}
}
