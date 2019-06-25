package com.lax.codeexercise;

/*
 * mplementation where multiple threads print alternate values of sequence
 */
public class RunThreadsInSequence {

	public class ResourceLock {
		public volatile int flag = 1;
	}

	public static void main(String[] args) {

		RunThreadsInSequence solution = new RunThreadsInSequence();
		ResourceLock lock = solution.new ResourceLock();

		ThreadA a = solution.new ThreadA(lock);
		ThreadB b = solution.new ThreadB(lock);
		ThreadC c = solution.new ThreadC(lock);

		a.start();
		b.start();
		c.start();
	}

	public class ThreadA extends Thread {

		ResourceLock lock;

		ThreadA(ResourceLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {

			try {
				synchronized (lock) {

					for (int i = 0; i < 100; i++) {

						while (lock.flag != 1) {
							lock.wait();
						}

						System.out.print("A ");
						Thread.sleep(1000);
						lock.flag = 2;
						lock.notifyAll();
					}

				}
			} catch (Exception e) {
				System.out.println("Exception 1 :" + e.getMessage());
			}

		}

	}

	public class ThreadB extends Thread {

		ResourceLock lock;

		ThreadB(ResourceLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {

			try {
				synchronized (lock) {

					for (int i = 0; i < 100; i++) {

						while (lock.flag != 2) {
							lock.wait();
						}

						System.out.print("B ");
						Thread.sleep(1000);
						lock.flag = 3;
						lock.notifyAll();
					}

				}
			} catch (Exception e) {
				System.out.println("Exception 2 :" + e.getMessage());
			}

		}
	}

	public class ThreadC extends Thread {

		ResourceLock lock;

		ThreadC(ResourceLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {

			try {
				synchronized (lock) {

					for (int i = 0; i < 100; i++) {

						while (lock.flag != 3) {
							lock.wait();
						}

						System.out.print("C ");
						Thread.sleep(1000);
						lock.flag = 1;
						lock.notifyAll();
					}

				}
			} catch (Exception e) {
				System.out.println("Exception 3 :" + e.getMessage());
			}

		}
	}
}
