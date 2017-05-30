package com.stackoverflow.tests;

/**
 * The bitwise & operator performs a bitwise AND operation.
 *	Binary AND Operator copies a bit to the result if it exists in both operands.
 */
public class Bitwise {

	public static void main(String[] args) {
		System.out.println(0000 & 0001); //exists only on right side
		System.out.println(0001 & 0001); //exists on both sides 
		
		System.out.println(0000 & 0000); //exists only on left side 
		System.out.println(0020 & 0020); //exists on both sides 
	}
}
