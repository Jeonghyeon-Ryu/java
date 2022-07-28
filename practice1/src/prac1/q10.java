package prac1;

import java.util.concurrent.atomic.AtomicInteger;

public class q10 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		
		Thread[] ta = {t1,t2,t3};
		for(int x=0; x<3; x++) {
			ta[x].start();
		}
		
	}
}

class MyThread implements Runnable {
	private static AtomicInteger count = new AtomicInteger(0);
	public void run() {
		int x = count.incrementAndGet();
		System.out.print(x +" ");
	}
}