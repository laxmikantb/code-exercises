package com.lax.codeexercise;

/*
 * binary searches in ordered arrays
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1,3,7,8, 10, 15, 45, 57 };
		int index = 0;
		if ((index = search(arr, 8)) != -1) {
			System.out.println(" Found key at " + index);
		}

		if ((index = search(arr, 5)) != -1) {
			System.out.println(" Found key at " + index);
		}
		else {
			System.out.println(" KLey not Found ");
		}
	}
	
	public static int search(int[] arr, int searchKey) {
		return search(arr, searchKey, 0, arr.length-1);
	}

	public static int search(int[] arr, int searchKey, int lowerBound, int upperBound) {
		int mid = (lowerBound + upperBound) / 2;
		if (arr[mid] == searchKey) {
			return mid;
		}
		
		if (lowerBound > upperBound) {
			return -1;
		}
		
		if (arr[mid] < searchKey) {
			lowerBound = mid+1;
			return search(arr,searchKey, lowerBound, upperBound);
		}
		else if (arr[mid] > searchKey) {
			upperBound = mid-1;
			return search(arr,searchKey, lowerBound, upperBound);
		}

		return -1;
	}
}
