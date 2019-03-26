package com.lax.codeexercise;

/* If a given number is Armstrong Number- An Armstrong Number of three digits is an integer such
that the sum of the cubes of its digits is equal to the number itself
e.g 371 is a ArmStrong Number since 3^3 + 7^3 + 1^1 = 371
*/

public class ArmStrongNumber {

	public static void main(String[] args) {
		System.out.println(isArmStrongNumber(371));
		System.out.println(isArmStrongNumber(371));

	}

	public static boolean isArmStrongNumber(int num) {
		int result = 0;
		int modulo = 0;
		int inum = num;
		while (inum != 0) {
			modulo = inum % 10;
			inum /= 10;
			result += (Math.pow(modulo, 3));
		}
		if (result == num)
			return true;
		return false;
	}

}
