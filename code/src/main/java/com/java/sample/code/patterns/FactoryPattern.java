package com.java.sample.code.patterns;

interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("I am a circle");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("I am a square");
	}
}

class ShapeFactory {
	
	Shape getShape(String type) {
		if (type == "circle") {
			return new Circle();
		} else if (type == "square") {
			return new Square();
		} else {
			System.out.println("Unknown shape");
			return null;
		}
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		ShapeFactory fac = new ShapeFactory();
		Shape circle = fac.getShape("circle");
		Shape square = fac.getShape("square");
		circle.draw();
		square.draw();
	}
}
