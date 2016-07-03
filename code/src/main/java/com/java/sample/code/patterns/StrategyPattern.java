package com.java.sample.code.patterns;

/**
* In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
* This type of design pattern comes under behavior pattern. In Strategy pattern, we create objects 
* which represent various strategies and a context object whose behavior varies as per its strategy object. 
* The strategy object changes the executing algorithm of the context object.
*/

class Context {
	private Strategy s;
	public Context(Strategy s) {
		this.s = s;
	}
	public int perform(int num1, int num2) {
		return s.doOperation(num1, num2);
	}
}
interface Strategy {
	int doOperation(int num1, int num2);
}
class AddStrategy implements Strategy {
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}
class MultiflyStrategy implements Strategy {
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}
public class StrategyPattern {
	public static void main(String[] args) {
		Context ctx = new Context(new AddStrategy());
		System.out.println("Add : " + ctx.perform(2, 3));
		ctx = new Context(new MultiflyStrategy());
		System.out.println("Multifly: " + ctx.perform(2, 3));
	}
}
