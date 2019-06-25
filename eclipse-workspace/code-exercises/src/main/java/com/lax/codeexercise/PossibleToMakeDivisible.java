package com.lax.codeexercise;

public class PossibleToMakeDivisible {
	public static boolean isPossibleToMakeDivisible(int arr[], int n) {
		// Find remainder of sum when divided by 3
		int remainder = 0;
		for (int i = 0; i < n; i++)
			remainder = (remainder + arr[i]) % 3;

		// Return true if remainder is 0.
		return (remainder == 0);
	}

	public static void main(String[] args) {
		int arr[] = { 40, 50, 90 };
		int n = 3;
		if (isPossibleToMakeDivisible(arr, n))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
	}
}
