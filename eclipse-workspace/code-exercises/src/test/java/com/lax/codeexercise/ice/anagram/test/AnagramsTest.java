package com.lax.codeexercise.ice.anagram.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.lax.codeexercise.Anagrams;

public class AnagramsTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testwithNumeric() {
		
		String line = "eat, tea, tan, ate, nat, bat, eat 123";
		String lines[] = line.split("\\r?\\n");
		List<Set<String>> list = Anagrams.getAnagrams(new ArrayList<String>(Arrays.asList(lines)));
        Set<String> expectedSet = Stream.of("tea", "ate", "eat")
				.collect(Collectors.toSet());
        Set<String> expectedSet2 = Stream.of("tan", "nat")
				.collect(Collectors.toSet());
        assertEquals(list.get(0), expectedSet);
        assertEquals(list.get(1), expectedSet2);	
	}
	

	@Test
	public void testMultipleLines() {
		String line = "abc cab tat aaa orchestra\n att tat bbb\n \ncabr\n rbac cab crab cabrc cabr carthorse 123 321";
		String lines[] = line.split("\\r?\\n");
		List<Set<String>> list = Anagrams.getAnagrams(new ArrayList<String>(Arrays.asList(lines)));
		assertEquals(5, list.size());
	}
	
	@Test
	public void testRepeatChars() {
		String line = " tat aaa att tat bbb ";
		String lines[] = line.split("\\r?\\n");
		List<Set<String>> list = Anagrams.getAnagrams(new ArrayList<String>(Arrays.asList(lines)));
		assertEquals(1, list.size());
        Set<String> expectedSet = Stream.of("att", "tat")
				.collect(Collectors.toSet());
        assertEquals(list.get(0), expectedSet);
	}
	
	@Test
	public void testWithDoubleQuotedWords() {
		String line = "\"apt\", \"tap\" and \"pat\"";
		String lines[] = line.split("\\r?\\n");
		Set<String> expectedSet = Stream.of("tap", "pat", "apt")
				.collect(Collectors.toSet());
		List<Set<String>> list = Anagrams.getAnagrams(new ArrayList<String>(Arrays.asList(lines)));
		assertEquals(list.get(0), expectedSet);
		
	}
	

}

