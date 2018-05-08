package waitnotif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static volatile boolean  isWaiting = false;

	public static void main(String[] args) throws IOException, InterruptedException {
		String[] lines = new String[1];
		Object lockObj = new Object();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockObj) {
					try {
						isWaiting = true;
						System.out.println("intra in wait");
						lockObj.wait();
						
						System.out.println("In threadul ala stiti voi " + lines[0]);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		t.start();
		Thread.sleep(2000);
		System.out.println("\n>>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//while(!isWaiting) {
		//	Thread.sleep(2000);

		//}
		synchronized (lockObj) {
			lines[0] = br.readLine();
			lockObj.notify();
			System.out.println("aici se face notify");
		}
	}

}
