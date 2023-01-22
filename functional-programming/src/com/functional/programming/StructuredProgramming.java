package com.functional.programming;

import java.util.List;

public class StructuredProgramming {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		System.out.println("ALL Numbers");
		printAllNumbersInList(numbers);
		System.out.println("\n\nEVEN Numbers");
		printEvenNumbersInList(numbers);
		System.out.println("\n\nODD Numbers");
		printOddNumbersInList(numbers);
	}

	private static void printAllNumbersInList(List<Integer> numbers) {
		for (Integer num : numbers) {
			System.out.print(num + ", ");
		}
	}

	private static void printEvenNumbersInList(List<Integer> numbers) {
		for (Integer num : numbers) {
			if (num % 2 == 0) {
				System.out.print(num + ", ");
			}
		}
	}

	private static void printOddNumbersInList(List<Integer> numbers) {
		for (Integer num : numbers) {
			if (num % 2 != 0) {
				System.out.print(num + ", ");
			}
		}
	}
}
