package com.stackoverflow.tests;

import java.util.*;
import java.util.function.Consumer;

public class IterablePerformance {

	public static void main(String[] args) {
	    List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	    Long a = System.nanoTime();
	    for (int i = 0; i < num.size(); i++) {
	        System.out.print(num.get(i));
	    }
	    System.out.printf(" for_loop ");
	    System.out.println(System.nanoTime()-a);
	    a = System.nanoTime();

	    for (int e : num) {
	        System.out.print(e);}

	    System.out.printf(" for_each ");
	    System.out.println(System.nanoTime() -a );

	    a = System.nanoTime();

	    num.forEach(new Consumer<Integer>() {
	        @Override
	        public void accept(Integer integer) {
	            System.out.print(integer);
	        }
	    });
	    System.out.printf(" for_internal ");
	    System.out.println(System.nanoTime()-a);

	    a = System.nanoTime();

	    num.forEach(System.out::print);
	    System.out.printf(" num_lambda ");
	    System.out.println(System.nanoTime()-a);

	    a = System.nanoTime();
	    num.stream().forEach(System.out::print);
	    System.out.printf(" num_stream ");
	    System.out.println(System.nanoTime()-a);
	}
}
