package com.lax.codeexercise;

public class SortString {

	static int MAX_CHAR = 26;

	// function to print string in sorted order
	static void sortString(String str) {

		// Hash array to keep count of characters.
		// Initially count of all charters is
		// initialized to zero.
		int charCount[] = new int[MAX_CHAR];

		// Traverse string and increment
		// count of characters
		// 'a'-'a' will be 0, 'b'-'a' will be 1,
		for (int i = 0; i < str.length(); i++) {

			// so for location of character in count
			// array we wil do str[i]-'a'.
			charCount[str.charAt(i) - 'a']++;
		}

		// Traverse the hash array and print
		// characters
		for (int i = MAX_CHAR - 1; i >= 0; i--) {
			for (int j = 0; j < charCount[i]; j++) {
				System.out.print((char) ('a' + i));
			}
		}
	}

	// Driver code
	public static void main(String[] args) {
		String s = "alkasingh";
		sortString(s);
	}
}
