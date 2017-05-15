package com.stackoverflow.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *JAVA 8 introduces a new concept for dealing with concurrencies  
 *CompletableFuture
 */

class MainWork {
	static int localInt;
	static String testString;

	public static void main(String args[]) throws IOException {
		
		CompletableFuture.supplyAsync(MainWork::doWork).thenAccept(System.out::println);
		System.in.read();
	}

	public static List<String> doWork() {
		localInt = 100;
		testString = "Hi";

		List<String> greettings = new ArrayList<String>();
		for (int x = 0; x < localInt; x++) {

			greettings.add(testString);
		}
		return greettings;
	}
}