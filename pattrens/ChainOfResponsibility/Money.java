package katrenich.pattrens.ChainOfResponsibility;

public class Money {
	private int amt;

	public Money(int atm) {
		this.amt = atm;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		if(amt>0 && amt<=2_000 && amt%Note.U50 == 0){
			this.amt = amt;
		} else {
			throw new RuntimeException("Сума коштів повинна бути не більше 2000 і кратна 50");
		}
	}

}
