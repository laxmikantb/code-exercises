package com.lax.codeexercise;

import java.util.ArrayList;
import java.util.List;

public class SplitString {

	// function to split String into subStrings
	// on the basis of delimiter and return
	// the subStrings after split
	static List<String> splitStrings(String str, char dl) {
		String word = "";

		// to count the number of split Strings
		int num = 0;

		// adding delimiter character
		// at the end of 'str'
		str = str + dl;

		// length of 'str'
		int l = str.length();

		// traversing 'str' from left to right
		List<String> substr_list = new ArrayList<>();
		for (int i = 0; i < l; i++) {

			// if str[i] is not equal to the delimiter
			// character then accumulate it to 'word'
			if (str.charAt(i) != dl) {
				word = word + str.charAt(i);
			} else {

				// if 'word' is not an empty String,
				// then add this 'word' to the array
				// 'substr_list[]'
				if ((int) word.length() != 0) {
					substr_list.add(word);
				}

				// reset 'word'
				word = "";
			}
		}

		// return the splitted Strings
		return substr_list;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "geeks;for;geeks";
		char dl = ';';
		List<String> res = splitStrings(str, dl);
		for (String x : res) {
			System.out.println(x);
		}
	}
}