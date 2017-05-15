package com.stackoverflow.tests;

import java.io.IOException;

public class Phone {
	int x = 6;

	int getx()// I also tried using this function but everything in vain
	{
		return x;
	}

	private static class Testing_inheritance extends Phone {
		public static void main(String args[]) throws IOException {
			Phone xy = new Phone();
			int y = xy.getx();
			y += 10;
			System.out.println("The value of x is " + y);
		}

	}
}