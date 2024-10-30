package bank.dto;

public class Deposit
{
	private long amt;

	public Deposit(long amt) {
		this.amt = amt;
	}

	public long getAmt() {
		return amt;
	}

	public void setAmt(long amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Deposit [amt=" + amt + "]";
	}
	
}
