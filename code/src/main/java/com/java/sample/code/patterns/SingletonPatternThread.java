package com.java.sample.code.patterns;

class SingletonClass {
	private static int counter;
	protected static SingletonClass _singleton = null;
	private SingletonClass() {
		counter++;
		System.out.println("I am singleton and my number is " + counter);
	}
	
	public static synchronized SingletonClass getInstance() {
		if ( _singleton == null ) {
			_singleton = new SingletonClass();
		}
		return _singleton; 
	}
}

class AnotherSingletonClass {
	private static int counter;
	protected volatile static AnotherSingletonClass _singleton = null;
	private AnotherSingletonClass() {
		counter++;
		System.out.println("I am singleton and my number is " + counter);
	}
	
	public static AnotherSingletonClass getInstance() {
		if ( _singleton == null ) {
			synchronized(AnotherSingletonClass.class) {
				if ( _singleton == null ) {
					_singleton = new AnotherSingletonClass();
				}
			}
		}
		return _singleton; 
	}
}

class YetAnotherSingletonClass {
	private static int counter;
	protected static YetAnotherSingletonClass _singleton = new YetAnotherSingletonClass();
	private YetAnotherSingletonClass() {
		counter++;
		System.out.println("I am singleton and my number is " + counter);
	}
	public static YetAnotherSingletonClass getInstance() {
		return _singleton; 
	}
}

public class SingletonPatternThread {
	public static void main(String[] args) {
		SingletonClass single1 = SingletonClass.getInstance();
		SingletonClass single2 = SingletonClass.getInstance();
	}
}