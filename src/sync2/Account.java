package sync2;

public class Account {
	private double mBalance;

	public synchronized void credit(double pAmount) {
		mBalance += pAmount;
	}

	public synchronized boolean debit(double pAmount) {
		if (mBalance >= pAmount) {
			mBalance -= pAmount;
			return true;
		}
		return false;
	}
}
