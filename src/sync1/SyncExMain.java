package sync1;

public class SyncExMain {
	private static Object lockObj = new Object();
	

	public static void main(String[] args) {
		Thread th1 = new Thread(() -> {
			System.out.println("TH1 started");
			synchronized (lockObj) {
				System.out.println("TH1 In sync block");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("TH1 about to exit sync block");
			}
		});
		Thread th2 = new Thread(() -> {
			System.out.println("TH2 started");
			synchronized (lockObj) {
				System.out.println("TH2 In sync block");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("TH2 about to exit sync block");
			}
		});
		th1.start();
		th2.start();
	}

}
