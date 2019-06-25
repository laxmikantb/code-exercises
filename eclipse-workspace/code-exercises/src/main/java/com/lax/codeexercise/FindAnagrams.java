package com.lax.codeexercise;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* set of anagrams of list of words, the output should be words which are anagrams 
 * from the list should be grouped together
 * */
public class FindAnagrams {

	public static void main(String[] args) {
		String text = "eat, tea, tan, ate, nat, bat, eat";
		ArrayList arr = new ArrayList<String>();
		arr.add(text);
		FindAnagrams.findList(new StringReader(text)).stream().forEach(System.out::println);
	}

	public static List<Set<String>> findList(Reader reader) {
		Stream<String> words = new BufferedReader(reader).lines().flatMap(Pattern.compile("\\W+")::splitAsStream)
				.distinct();
		Map<String, Set<String>> resultMap = words.collect(Collectors.groupingBy(
				s -> s.codePoints().sorted()
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString(),
				Collectors.toSet()));

//		Map<String, Set<String>> map = arr.stream()
//				.flatMap(Pattern.compile("\\W+")::splitAsStream).distinct()
//				.collect(Collectors.groupingBy(s -> s.codePoints().sorted()
//						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
//				, Collectors.toSet()));

		return resultMap.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
	}

}