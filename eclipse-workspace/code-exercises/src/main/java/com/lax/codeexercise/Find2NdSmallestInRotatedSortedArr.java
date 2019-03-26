package com.lax.codeexercise;

/*
 * 2nd smallest of a sorted rotated array e.g 5,6,1,2,3,4 => 2
 */
public class Find2NdSmallestInRotatedSortedArr {

	public static void main(String[] args) {
		int[] a = { 5, 6, 2, 2, 3 };
		int alen = a.length;
		int pivotIndex = 0;
		int secondSmallestIndex = -1;
		if ((pivotIndex = findSmallestIndex(a, 0, alen - 1)) != -1) {
			// System.out.println("First Smallest " + a[pivotIndex]);
			if (pivotIndex == alen - 1) {
				secondSmallestIndex = 0;
			} else
				secondSmallestIndex = pivotIndex + 1;
			System.out.println("second Smallest " + a[secondSmallestIndex]);
		}
		int[] b = { 2, 3, 4, 5, 1 };
		alen = b.length;
		pivotIndex = 0;
		secondSmallestIndex = -1;
		if ((pivotIndex = findSmallestIndex(b, 0, alen - 1)) != -1) {
			System.out.println("First Smallest " + b[pivotIndex]);
			if (pivotIndex == alen - 1) {
				secondSmallestIndex = 0;
			} else
				secondSmallestIndex = pivotIndex + 1;
			System.out.println("second Smallest " + b[secondSmallestIndex]);
		}
	}

	public static int findSmallestIndex(int[] arr, int low, int high) {
		if (arr.length <= 1)
			return -1;
		if (high < low)
			return 0;
		if (low == high)
			return low;
		int mid = low + (high - low) / 2;
		if (mid < high && arr[mid + 1] < arr[mid]) {
			return mid + 1;
		}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid;
		}
		if (arr[high] > arr[mid])
			return findSmallestIndex(arr, low, mid - 1);
		return findSmallestIndex(arr, mid + 1, high);

	}

}
