package com.stackoverflow.tests;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class KeyTypeLinkedHashSet {

	
	
	public static void main(String[] args) {
		
		LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<Long>();
		
		linkedHashSet.add(50L);
		linkedHashSet.add(150L);
		linkedHashSet.add(250L);
		linkedHashSet.add(350L);
		
		Iterator<Long> keyIt =  linkedHashSet.iterator();
		while (keyIt.hasNext()) {
			Long key = keyIt.next();
			System.out.println("key instanceof Long:" + (key instanceof Long));
			
		}
		
		Long[] longArray = linkedHashSet.toArray(new Long[linkedHashSet.size()]);
		
		for (Long long1 : longArray) {
			System.out.println(long1);
		}
	}
}
