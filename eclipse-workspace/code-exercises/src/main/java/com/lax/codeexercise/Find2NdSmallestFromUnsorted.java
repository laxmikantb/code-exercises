package com.lax.codeexercise;
/*
 * 2nd smallest 
 */

public class Find2NdSmallestFromUnsorted {

	public static void main(String[] args) {
		int[] result = new int[2];
		int[] a = { 1, 89, 20, 3, 21, 0, 16 };
		if (findSmallest(a, result)) {
			System.out.println("Second smallest " + result[1]);
		}

	}

	public static boolean findSmallest(int[] a, int[] result) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		if (a.length <= 2) {
			result[0] = -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] < first) {
				second = first;
				first = a[i];
			} else if (a[i] < second && a[i] != first) {
				second = a[i];
			}
		}

		result[0] = first;
		result[1] = second;
		if (result[0] == Integer.MAX_VALUE || result[1] == Integer.MAX_VALUE)
			return false;

		return true;
	}

}
