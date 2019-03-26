package com.lax.codeexercise.sort;

public class MergeSort {

	public static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[] { 100, 54, 23, 1, 18, 14, 29, 45, 23 };
		int[] workspace = new int[arr.length];
		recMergeSort(workspace, 0, arr.length-1);
		for (int j=0; j < arr.length; j++) {
			System.out.print(" " + arr[j]);
		}
		System.out.println();
	}
	
	public static void recMergeSort(int[] workspace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound)
			return;
		int mid = (lowerBound + upperBound) / 2;
		recMergeSort(workspace, lowerBound, mid);
		recMergeSort(workspace, mid+1, upperBound);
		
		merge(workspace,lowerBound,mid+1, upperBound);
	}
	
	public static void merge(int[] workspace, int lowPtr, int highPtr, int upperBound) {
		int mid = highPtr -1;
		int n = upperBound - lowPtr + 1;
		int lowerBound = lowPtr;
		int j=0;
		
		while(lowPtr <= mid && highPtr <= upperBound)
			if (arr[lowPtr] < arr[highPtr])
			{
				workspace[j++] = arr[lowPtr++];
			}
			else {
				workspace[j++] = arr[highPtr++];
			}
		
		
		while(lowPtr <= mid) {
			workspace[j++] = arr[lowPtr++];
		}
		
		while(highPtr <= upperBound) {
			workspace[j++] = arr[highPtr++];
		}
		
		for (j=0; j < n; j++) {
			arr[j+ lowerBound] = workspace[j];
		}
				
	}

}
