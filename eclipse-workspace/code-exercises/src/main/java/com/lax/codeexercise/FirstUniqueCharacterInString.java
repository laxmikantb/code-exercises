package com.lax.codeexercise;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Find unique character in a string e.g aaabcbdcce => d 
 */
public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		System.out.println(FindUniqueCharacter("aabbcc"));
		System.out.println(FindUniqueCharacter("zabbcc"));
	}

	public static char FindUniqueCharacter(String s) {
		char[] chars = s.toCharArray();
		LinkedHashMap<Character, Integer> lm = new LinkedHashMap<Character, Integer>();

		for (char ch : s.toCharArray()) {
			Integer count = lm.getOrDefault(ch, 0);
			lm.put(ch, count + 1);
		}
		char uniqueChar = 0;
		for (Map.Entry<Character, Integer> entry : lm.entrySet()) {
			if (entry.getValue() == 1) {
				uniqueChar = entry.getKey();
				break;
			}
		}
		if (uniqueChar != 0) {
			System.out.println("Unique Char " + uniqueChar);
		} else {
			System.out.println("No Unique Char Found");
		}

		return uniqueChar;
	}
}
