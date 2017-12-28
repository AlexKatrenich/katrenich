package katrenich.pattrens.ChainOfResponsibility;


public class NoteModule50 extends NoteModule{
	@Override
	void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.U50;
		int reminder = money.getAmt()%Note.U50;

		if(countNote > 0){
			System.out.println("Видано: " + countNote + " купюр, номіналом - " + Note.U50);
		}
		if(reminder>0 && super.next!=null){
			super.next.takeMoney(new Money(reminder));
		} else {
			System.out.println("Залишилось: " + reminder + " не виданих коштів.");
		}
	}
}
