package daemon1;

public class DaemonExMain {

	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(() ->  {
			// THread-ul nostru
			while(true) {
				System.out.println("About to sleep");
				try {
					Thread.sleep(1000);
					System.out.println("Woke up");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		th1.setDaemon(true);
		th1.start();
		System.err.println("About to exit main thread");
		th1.join();
	}

}
