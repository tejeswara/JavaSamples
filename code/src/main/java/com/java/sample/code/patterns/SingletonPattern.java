package com.java.sample.code.patterns;

class Singleton {
	private static int counter;
	private static Singleton _singleton = null;
	
	private Singleton() {
		counter++;
		System.out.println("I am singleton and my number is " + counter);
	}
	
	public static Singleton getInstance() {
		if ( _singleton == null ) {
			_singleton = new Singleton();
		}
		return _singleton; 
	}
}

public class SingletonPattern {
	public static void main(String[] args) {
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
	}
}
