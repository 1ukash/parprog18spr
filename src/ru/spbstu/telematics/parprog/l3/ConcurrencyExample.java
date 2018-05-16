package ru.spbstu.telematics.parprog.l3;

import java.util.LinkedList;
import java.util.List;

public class ConcurrencyExample {

	static final int PRICE = 3;
	static Shop shop = new Shop();

	static class Shop {
		int account = 0;
		int goods = 1000000;

		public int getAccount() {
			return account;
		}

		public void setAccount(int account) {
			this.account = account;
		}

		public int getGoods() {
			return goods;
		}

		public void setGoods(int goods) {
			this.goods = goods;
		}
	}

	static class Buyer implements Runnable {

		int account = 900000;
		int goods = 0;

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

				if (PRICE > account) {
					return;
				}
				synchronized (shop) {
					if (shop.getGoods() <= 0) {
						return;
					}
					goods++;
					account -= PRICE;
					shop.setGoods(shop.getGoods() - 1);
					shop.setAccount(shop.getAccount() + PRICE);
				}

				// try {
				// Thread.sleep(10);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		List<Thread> t = new LinkedList<>();
		List<Buyer> b = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			Buyer b1 = new Buyer();
			Thread t1 = new Thread(b1);
			t1.start();
			t.add(t1);
			b.add(b1);
		}

		for (Thread ti : t) {
			ti.join();
		}

		System.out.println("Money in shop " + shop.getAccount());
		System.out.println("Goods in shop " + shop.getGoods());

		for (int i = 0; i < b.size(); i++) {
			System.out.println("Byer #" + i + ": goods=" + b.get(i).goods + ", money=" + b.get(i).account);
		}
	}
}
