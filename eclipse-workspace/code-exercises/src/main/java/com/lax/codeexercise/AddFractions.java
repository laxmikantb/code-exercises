package com.lax.codeexercise;

// Program to add two fractions

public class AddFractions {

	public static void main(String[] args) {
		System.out.println(gcd(499, 1500));
		int num1 = 1, den1 = 499, num2 = 2, den2 = 1500;
		System.out.print(num1 + "/" + den1 + " + " + num2 + "/" + den2 + " is equal to ");
		addFractions(num1, den1, num2, den2);

	}

	public static int gcd(int first, int second) {
		if (first == 0)
			return second;
		return gcd(second % first, first);
	}

	public static void addFractions(int num1, int den1, int num2, int den2) {
		int den3 = gcd(den1, den2);
		// Denominator of final fraction obtained
		// finding LCM of den1 and den2
		// LCM * GCD = a * b
		den3 = (den1 * den2) / den3;

		// Changing the fractions to have same denominator
		// Numerator of the final fraction obtained
		int num3 = num1 * (den3 / den1);
		num3 += num2 * (den3 / den2);

		// Calling function to convert final fraction
		// into it's simplest form
		lowest(den3, num3);
	}

	public static void lowest(int den, int num) {
		// Finding gcd of both terms
		int common_factor = gcd(num, den);

		// Converting both terms into simpler
		// terms by dividing them by common factor
		den = den / common_factor;
		num = num / common_factor;
		System.out.println(num + "/" + den);
	}

}
