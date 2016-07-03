package com.java.sample.code.patterns;

//Define what the singleton must do.
interface MySingleton {
	public void doSomething();
}

public enum SingletonPatternEnum implements MySingleton {

	/**
	 * The one and only instance of the singleton.
	 *
	 * By definition as an enum there MUST be only one of these and it is inherently thread-safe.
	 */
	INSTANCE {
             public void doSomething() {
            	 System.out.println("Do something");
             }
         };

	public static MySingleton getInstance() {
		return SingletonPatternEnum.INSTANCE;
	}
}