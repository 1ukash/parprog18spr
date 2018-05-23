package ru.spbstu.telematics.parprog.l4;

import java.util.Random;

public class WaitNotify {

	static Object lock1 = new Object();
	
	static int val = 0;

	static class T1 implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				
				synchronized (lock1) {
					System.out.println(Thread.currentThread().getName() + " is going to wait");
					try {
						lock1.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + " wake up and result from T1 is " + val);
				}
			}
		}

	}

	static class T2 implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				
				System.out.println(Thread.currentThread().getName() + " is doing  computations for some time");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				val = new Random().nextInt(100);
				System.out.println(Thread.currentThread().getName() + " has completed  computations with result " + val);
				synchronized (lock1) {
					lock1.notify();
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
