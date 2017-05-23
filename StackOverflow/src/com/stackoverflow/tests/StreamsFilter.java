package com.stackoverflow.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * Java8 Features
 * This question was removed from Stackoverflow by author
 * This is a simple example to use Streams Filter 
 * @author Guilherme 
 *
 */
public class StreamsFilter {
	public static void main(String[] args) {
		StreamsFilter streamsFilter = new StreamsFilter();

		List<Integer> numbersList = streamsFilter.returnNumbers(20);
		List<String> numbersStrList = streamsFilter.returnNumbersString(20);
		List mixedList = new ArrayList();

		mixedList.addAll(numbersList);
		mixedList.addAll(numbersStrList);

		System.out.println("--- List merged Integers and Strings ---");
		mixedList.forEach(System.out::println);

		Stream result = mixedList.stream().filter(value -> value.getClass().equals(String.class));//lambda expression, method as value

		System.out.println("--- List filtered Strings ---");
		result.forEach(System.out::println); //new java8 feature forEach and method reference :: 

		result = mixedList.stream().filter(value -> value.getClass().equals(Integer.class));

		System.out.println("--- List filtered Integer ---");
		result.forEach(System.out::println);
	}

	public List<Integer> returnNumbers(Integer qtd) {
		List<Integer> listNumbers = new ArrayList<Integer>();

		for (int x = 0; x < qtd; x++) {
			listNumbers.add(x);
		}

		return listNumbers;
	}

	public List<String> returnNumbersString(Integer qtd) {
		List<String> listNumbers = new ArrayList<String>();

		for (int x = 0; x < qtd; x++) {
			listNumbers.add("" + x);
		}

		return listNumbers;
	}
}
