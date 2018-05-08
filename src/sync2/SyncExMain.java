package sync2;

public class SyncExMain {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Account acc = new Account();
		for(int i=0;i < 10000000;i++) {
			acc.credit(0.1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Duration:" + (endTime - startTime)/1000.0);
	}

}
