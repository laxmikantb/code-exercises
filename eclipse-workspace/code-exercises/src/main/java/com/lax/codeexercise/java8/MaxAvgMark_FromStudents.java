package com.lax.codeexercise.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxAvgMark_FromStudents {

	static class Student {
		public Student(String string, int i) {
			this.name = string;
			this.mark = i;
		}

		String name;

		public String getName() {
			return name;
		}

		Integer mark;

		public Integer getMark() {
			return mark;
		}
	}

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new MaxAvgMark_FromStudents.Student("Jerry", 65),
				new MaxAvgMark_FromStudents.Student("Jerry", 68), new MaxAvgMark_FromStudents.Student("Jerry", 100),
				new MaxAvgMark_FromStudents.Student("Eric", 99), new MaxAvgMark_FromStudents.Student("bob", 100),
				new MaxAvgMark_FromStudents.Student("Eric", 65), new MaxAvgMark_FromStudents.Student("bob", 200),
				new MaxAvgMark_FromStudents.Student("bobby", 100), new MaxAvgMark_FromStudents.Student("bob", 300));

		Map<String, Long> counting = students.stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

		System.out.println(counting);

		Map<String, Double> avg = students.stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.averagingInt(Student::getMark)));

		System.out.println(avg);
		String max = avg.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println("Max " + max);
	}

}
