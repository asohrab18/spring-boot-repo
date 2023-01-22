package com.functional.programming;

import java.util.List;

public class FunctionalProgrammingExercises {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		System.out.println("ALL Numbers");
		printAllNumbers(numbers);
		System.out.println("\nEVEN Numbers");
		printEvenNumbers(numbers);
		System.out.println("\nSQUARE of EVEN Numbers");
		printSquareOfEvenNumbers(numbers);
		System.out.println("\nODD Numbers");
		printOddNumbers(numbers);
		System.out.println("\nCUBES of ODD Numbers");
		printCubesOfOddNumbers(numbers);

		System.out.println("\n--------ALL Courses--------------");
		List<String> courses = List.of("AWS", "C", "C++", "Core Java", "Spring Boot", "Spring AOP", "Microservices");
		printAllCourses(courses);
		System.out.println("\n--------ALL Courses with number of characters--------------");
		printAllCoursesWithNumberOfCharacters(courses);
		System.out.println("\n----------Specific Courses------------");
		printSpecificCourses(courses, "Spring");
		System.out.println("\n----------Courses with limited letters------------");
		printCoursesWithLimitedLetters(courses, 4);
	}

	private static void printAllNumbers(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
	}

	private static void printEvenNumbers(List<Integer> numbers) {
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}

	private static void printSquareOfEvenNumbers(List<Integer> numbers) {
		numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).forEach(System.out::println);
	}

	private static void printOddNumbers(List<Integer> numbers) {
		numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
	}

	private static void printCubesOfOddNumbers(List<Integer> numbers) {
		numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n * n).forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}

	private static void printAllCoursesWithNumberOfCharacters(List<String> courses) {
		courses.stream().map(c -> c + " {" + c.length() + "}").forEach(System.out::println);
	}

	private static void printSpecificCourses(List<String> courses, String word) {
		courses.stream().filter(c -> c.contains(word)).forEach(System.out::println);
	}

	private static void printCoursesWithLimitedLetters(List<String> courses, Integer numberOfLetters) {
		courses.stream().filter(c -> c.length() >= numberOfLetters).forEach(System.out::println);
	}
}
