package com.stackoverflow.tests;

class A {

}

class B extends A {

}

class C extends B {

}

public class MainClass {
	static void overloadedMethod(A a) {
		System.out.println("1");

	}

	static void overloadedMethod(B b) {
		System.out.println("2");

	}

	static void overloadedMethod(C c) {
		System.out.println("3");
	}
	
	static void overloadedMethod(Object o) {
		System.out.println("3");
	}
	
	static void overloadedMethod(Class<? extends A> o) {
		System.out.println("4");
	}

	public static void main(String[] args) {
				
		Object o = new C();
		overloadedMethod(o);

	}
}