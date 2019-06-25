package com.lax.codeexercise;

public class ReversespiralMatrix {
	public static int R = 3, C = 6;

	// Function that print matrix in reverse spiral form.
	public static void ReversespiralPrint(int m, int n, int a[][]) {
		// Large array to initialize it
		// with elements of matrix
		long b[] = new long[100];

		/*
		 * k - starting row index l - starting column index
		 */
		int i, row = 0, col = 0;

		// Counter for single dimension array
		// in which elements will be stored
		int z = 0;

		// Total elements in matrix
		int size = m * n;

		while (row < m && col < n) {
			// Variable to store value of matrix.
			int val;

			/*
			 * Print the first row from the remaining rows
			 */
			for (i = col; i < n; ++i) {

				val = a[row][i];
				b[z] = val;
				++z;
			}
			row++;

			/*
			 * Print the last column from the remaining columns
			 */
			for (i = row; i < m; ++i) {

				val = a[i][n - 1];
				b[z] = val;
				++z;
			}
			n--;

			/*
			 * Print the last row from the remaining rows
			 */
			if (row < m) {
				for (i = n - 1; i >= col; --i) {

					val = a[m - 1][i];
					b[z] = val;
					++z;
				}
				m--;
			}

			/*
			 * Print the first column from the remaining columns
			 */
			if (col < n) {
				for (i = m - 1; i >= row; --i) {

					val = a[i][col];
					b[z] = val;
					++z;
				}
				col++;
			}
		}

		for (int x = size - 1; x >= 0; --x) {
			System.out.print(b[x] + " ");
		}
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		ReversespiralPrint(R, C, a);

	}
}
