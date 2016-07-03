package com.java.sample.code.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		
		/** example on how to define a Consumer using lambda exp */
		Consumer<String> consumer = (s) -> {
			ConsumerDemo.printUpper(s);
			ConsumerDemo.printLower(s);
			ConsumerDemo.printHashcode(s);
		};
		/** Calling consumer accept */
		consumer.accept("tej");
		consumer.accept("rani");
		
		List<String> names = Arrays.asList(new String[]{"Div", "Sarat"});
		
		/** example on passing consumer as parameter */
		print(names, (s) -> ConsumerDemo.printUpper(s));
	}
	
	public static void print(List<String> ss, Consumer<String> c) {
		ss.forEach(s -> c.accept(s));
	}
	
	private static void printUpper(String s) {
		System.out.println(s.toUpperCase());
	}
	
	private static void printLower(String s) {
		System.out.println(s.toLowerCase());
	}
	
	private static void printHashcode(String s) {
		System.out.println(s.hashCode());
	}
}
