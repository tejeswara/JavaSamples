package com.java.sample.code.lambdas;

import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<String> supplier = () -> myStr();
		System.out.println(supplier.get());
		Employee emp = new Employee(34, "Tej");
		Employee suppliedEmployee = getEmployee( () -> emp );
		System.out.println("Employee Age " + suppliedEmployee.getAge() + " Name " + suppliedEmployee.getName());
	}
	
	public static Employee getEmployee(Supplier<Employee> supplier) {
		return supplier.get();
	}
	private static String myStr() {
		return "hello";
	}
}

class Employee {
	int age;
	String name;
	
	public Employee(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
}
