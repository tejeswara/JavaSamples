package com.java.sample.code.lambdas;

public class LambdaDemo {
	public static void main(String[] args) {
		Runnable runone = new Runnable() {
			public void run() {
				System.out.println("Run one");
			}
		};
		Runnable runtwo = () -> System.out.println("Run two");
		runone.run();
		runtwo.run();
	}
}
