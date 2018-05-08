package int1;

public class InterruptExMain {

	public static void main(String[] args) {
		Thread th1 = new Thread(() ->  {
			// THread-ul nostru
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println("About to sleep");
				try {
					Thread.sleep(1000);
					System.out.println("Woke up");

				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}

			}
		});
		// MAIN THREAD
		th1.start();
		try {
			System.err.println("Wait for join");
			th1.join(2000);
			System.err.println("Wait for join done");
			th1.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
