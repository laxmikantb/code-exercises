package com.lax.codeexercise;

public class LockOrderingDeadLock {
	private final Object left = new Object();
	private final Object right = new Object();
	
	public void leftRight() {
		synchronized(left) {
			synchronized(right) {
				// do something
			}
		}
	}
	
	public void rightLeft() {
		synchronized(right) {
			synchronized(left) {
				// do something
			}
		}
	}
}
