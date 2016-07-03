package com.java.sample.code.generics;

class Student {
	int id;
	String name;
	public int getId() { return id; }
	public String getName() { return name; }
	public void setId(int id) { this.id = id; }
	public void setName(String name) { this.name = name; }
}

public class ClassDemo {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unchecked")
			Class<Student> klass = (Class<Student>)Class.forName("com.java.sample.code.generics.Student");
			ClassLoader loader = klass.getClassLoader();
			loader.loadClass("com.java.sample.code.generics.Student");
			System.out.println(klass.getName());
			Student student = klass.newInstance();
			student.setId(123);
			student.setName("Tej");
			System.out.println("ID " + student.getId() + " Name " + student.getName());
		} catch( ClassNotFoundException e) {
			System.out.println("Could not find class");
		}  catch( Exception e) {
			System.out.println("Unknown exception");
		}
	}
}
