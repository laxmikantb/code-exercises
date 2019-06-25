package com.lax.codeexercise;

public class FindLastIndex {

	// Returns last index of x if
	// it is present Else returns -1.
	static int findLastIndex(String str, Character x) {
		int index = -1;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == x)
				index = i;
		return index;
	}

	// Driver code
	public static void main(String[] args) {
		// String in which char is to be found
		String str = "geeksforgeeks";

		// char whose index is to be found
		Character x = 'e';

		int index = findLastIndex(str, x);
		if (index == -1)
			System.out.println("Character not found");
		else
			System.out.println("Last index is " + index);
	}
}
