package deadlock1;

public class Main {
	
	static void transaction(Account pDebitAcc,Account pCreditAcc, double amount) {
		if(pDebitAcc.compareTo(pCreditAcc) == 0) {
			return;
		}
		if(pDebitAcc.compareTo(pCreditAcc) < 0) {
			synchronized (pDebitAcc) {
				pDebitAcc.debit(amount);
				synchronized (pCreditAcc) {
					pCreditAcc.credit(amount);
				}
			}
		} else {
			synchronized (pCreditAcc) {
				pCreditAcc.credit(amount);
				synchronized (pDebitAcc) {
					pDebitAcc.debit(amount);
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		Account acc1 = new Account("1");
		Account acc2 = new Account("2");

		Thread th1 = new Thread(() -> {
			transaction(acc1, acc2, 10);
		});
		Thread th2 = new Thread(() -> {
			transaction(acc2, acc1, 10);
		});
		th1.start();
		th2.start();
	}

}
