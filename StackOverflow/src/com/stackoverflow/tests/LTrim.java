package com.stackoverflow.tests;

public class LTrim {

	/**
	 * My requirement is:
	 * 
	 * 000000030899039 --> 30899039, 
	 * 0-200IT-700 --> 0-200IT-700, 
	 * 01-200IT-600	 * --> 1-200IT-600, 
	 * 000-200IT-700 --> 0-200IT-700 
	 * Is there a way? Zero
	 * before "-" should not be removed/stripped.
	 */

	public static void main(String[] args) {

//		String numbersWithZeros = "00000003089903";
//		String numbersWithZeros = "000-200IT-700";
//		String numbersWithZeros = "01-200IT-600";
		String numbersWithZeros = "000-200IT-700";
		String numbersWithoutZeros = numbersWithZeros.replaceAll("^0[0]+(.*)", "0$1");

		System.out.println(numbersWithoutZeros);
	}
}
