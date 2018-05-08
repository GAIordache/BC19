package tl;

public class ThreadLocalMain {
	static ThreadLocal<String> userName = new ThreadLocal<>();
	
	static void meth1(String pName) {
		userName.set(pName);
		meth2();
	}
	
	static void meth2() {
		System.out.println(Thread.currentThread().getName() + " -> " + userName.get());
	}

	public static void main(String[] args) {
		new Thread(() -> {
			meth1("gigi");
		}).start();
		new Thread(() -> {
			meth1("pufi");
		}).start();
		new Thread(() -> {
			meth1("gaga");
		}).start();
	}

}
