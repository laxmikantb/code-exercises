package com.lax.codeexercise.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSoution {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		for (int i=0; i < 100000; i++)
			l.add(i);
		List<Integer> k = l.parallelStream().map(i -> i * 2).collect(Collectors.toList());
		for (Integer i : k) {
			System.out.println(i);
		}
		//.forEach(System.out::println);
		
		l.add(1);
		l.add(4);
		List<Integer> result = scale(l, 1); 
		/* for (Integer i : result) {
		  System.out.println(i); }
		 */

		l.add(10);
		 result = scale(l, 0);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

	final private static Integer divide(Integer value, Integer factor) {
	    try {
	        return value / factor;
	    } catch (ArithmeticException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	public static List<Integer> scale(List<Integer> values, Integer factor) {
	    return values.stream()
	        .map(n -> divide(n, factor))
	        .collect(Collectors.toList());
	}
}
