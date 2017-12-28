package katrenich.pattrens.ChainOfResponsibility;


public class NoteModule200 extends NoteModule{

	@Override
	void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.U200;
		int reminder = money.getAmt()%Note.U200;

		if(countNote > 0){
			System.out.println("Видано: " + countNote + " купюр, номіналом - " + Note.U200);
		}
		if(reminder>0 && super.next!=null){
			super.next.takeMoney(new Money(reminder));
		} else {
			System.out.println("Залишилось: " + reminder + " не виданих коштів.");
		}
	}
}
