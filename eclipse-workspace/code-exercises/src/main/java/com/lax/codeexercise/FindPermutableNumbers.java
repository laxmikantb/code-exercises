package com.lax.codeexercise;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 3.	Permuted multiples
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, 
but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

 */
public class FindPermutableNumbers {

	public static void main(String[] args) {
		int i = 1;
		int count = 0;
		while (true) {
			if (isPermutable(i++)) {
				count++;
				if (count > 5)
					break;
			}
		}

	}

	public static boolean isPermutable(int num) {
		ArrayList<Integer> resultArr = new ArrayList<Integer>();
		resultArr.add(num);

		for (int i = 2; i < 7; i++) {
			int result = num * i;
			if (!isValidPermutable(Integer.toString(num), Integer.toString(result))) {
				break;
			}
			resultArr.add(result);
		}
		if (resultArr.size() == 6) {
			System.out.println("Permutable Integer " + num + " " + resultArr);
			return true;
		}
		return false;
	}

	public static boolean isValidPermutable(String origDIgits, String newDigits) {
		String orgSortedDigits = origDIgits.codePoints().sorted()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		String newSortedDigits = newDigits.codePoints().sorted()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		if (orgSortedDigits.contentEquals(newSortedDigits))
			return true;
		return false;
	}

}
