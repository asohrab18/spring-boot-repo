package com.functional.programming;

import java.util.List;
import java.util.Optional;

public class OptionalClassExercises {

	public static void main(String[] args) {
		// playWithOptional();
		greet("baby");
	}

	public static void greet(String name) {
		Optional<String> optName = Optional.ofNullable(name);
		if (optName.isEmpty()) {
			System.out.println("null value");
		}
		if (optName.isPresent()) {
			System.out.println("Welcome, " + name.toUpperCase() + "!");
		}

	}

	public static void playWithOptional() {
		List<String> fruits = List.of("Apple", "Banana", "Mango");
		Optional<String> opt = fruits.stream().filter(f -> f.startsWith("B")).findFirst();
		System.out.println(opt);
		System.out.println("isEmpty = " + opt.isEmpty());
		System.out.println("isPresent = " + opt.isPresent());
		if (opt.isPresent()) {
			System.out.println("Value = " + opt.get());
		}
		Optional<String> emptyOpt = Optional.empty();
		System.out.println("emptyOpt = " + emptyOpt);

		Optional<String> fruitOpt = Optional.of("Guava");
		System.out.println("fruitOpt = " + fruitOpt);
	}
}
