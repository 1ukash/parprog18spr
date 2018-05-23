package ru.spbstu.telematics.parprog.l4;

public class DeadLockExample {
	
	
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	static class T1 implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				synchronized (lock1) {
					
					// do something with data
					
					synchronized (lock2) {
						// do something with another data
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is still alive");
					}
					
				}
			}
		}
		
	}
	
	static class T2 implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				synchronized (lock1) {
					
					// do something with data
					
					synchronized (lock2) {
						// do something with another data
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is still alive");
					}
					
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		
	}

}
