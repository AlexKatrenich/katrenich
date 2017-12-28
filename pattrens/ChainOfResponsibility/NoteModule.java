package katrenich.pattrens.ChainOfResponsibility;

public abstract class NoteModule {
	protected NoteModule next;

	abstract void takeMoney(Money money);

	void setNextMoneyModule(NoteModule noteModule){
		next = noteModule;
	}
}
