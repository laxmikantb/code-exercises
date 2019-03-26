package com.lax.codeexercise.ice.anagram;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Anagrams {

	public static void main(String[] args) {
		
	}
	
	public static List<Set<String>> getAnagrams(ArrayList<String> line) {

		Map<String, Set<String>> anagramSet = line.stream()
				.flatMap(Pattern.compile("\\W+")::splitAsStream).distinct().collect(Collectors.groupingBy(
						s -> s.codePoints().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
						, Collectors.toSet()));
		return anagramSet.values().stream().filter(list -> (list.size() > 1)).collect(Collectors.toList());
	}
	

}
