package com.lax.codeexercise;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 100, 54, 23, 1, 18, 14, 29, 45, 23 };
		sort(arr, 0, arr.length-1);
		
		for (int i=0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
	
	public static void sort(int[] a, int left, int right) { 
			if (right - left <= 0)
				return;
			else {
				int pivot = a[right];
				int index = partition(a, left, right, pivot);
				sort(a, left, index -1);
				sort(a, index+1, right);
			}
	}

	public static int partition(int[] a, int left, int right, int pivot) {
		int leftPtr = left -1;
		int rightPtr = right;
		while(true) {
			while (a[++leftPtr] < pivot);
			while(rightPtr > 0 && a[--rightPtr] > pivot);
			if (leftPtr >= rightPtr)
				break;
			swap(a, leftPtr, rightPtr);
		}
		swap(a, leftPtr, right);
		return leftPtr;
	}
	
	public static void swap(int[] a, int left, int right) {
		int temp = a[right];
		a[right] = a[left];
		a[left] = temp;
	}
}
