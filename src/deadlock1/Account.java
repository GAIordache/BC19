package deadlock1;

public class Account implements Comparable<Account> {
	private String accountNo;
	private double mBalance;
	
	public Account(String pAccNo) {
		accountNo = pAccNo;
	}

	public void credit(double pAmount) {
		System.out.println("credit :" + this);
		mBalance += pAmount;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end credit :" + this);

	}

	public boolean debit(double pAmount) {
		System.out.println("debit :" + this);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (mBalance >= pAmount) {
			mBalance -= pAmount;
			System.out.println("end debit :" + this);

			return true;
		}
		System.out.println("end debit :" + this);

		return false;
	}

	@Override
	public int compareTo(Account pO) {
		return accountNo.compareTo(pO.accountNo);
	}
}
