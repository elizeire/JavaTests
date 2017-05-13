package com.example.runtests;

import static org.junit.Assert.*;

import org.junit.Test;

import junitConfiguration.HelloWorld;


public class HelloWorldTest {

	@Test
	public void test() {
		HelloWorld helloWorld = new HelloWorld();
		String hello = helloWorld.sayHello("Kirill");
		assertEquals("hello Kirill", hello);
	}

}
