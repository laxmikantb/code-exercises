package com.lax.codeexercise;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseListOfWords {

	public static List<String> getReversedWords(String str) {
		List<String> items= Stream.of(str.split(" "))
			     .map(String::trim)
			     .collect(Collectors.toList());
		Collections.reverse(items);
		return items;
	}
	
	public static void main(String[] args) {
		String s = "My Name is Lax";
		getReversedWords(s);
	}
}
