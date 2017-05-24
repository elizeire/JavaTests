package com.stackoverflow.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


/**
 * https://stackoverflow.com/questions/35534906/java-hashmap-getobject-infinite-loop
 * 
 * Playing around with HashMap and ConcurrentHashMap
 * @author elizeire
 *
 */
public class MyCache {
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
		CompletableFuture.supplyAsync(MyCache::runGetObject).thenAccept(x ->x.map.keySet().forEach(System.out::println));
				
		System.in.read();
		
	}
	

	private static MyCache runGetObject() {
		MyCache cache = fillCache(999);
		System.out.println("infinite loop?");
		System.out.println(cache.get("key_0"));
		System.out.println("idt so");
		return cache;
	}

	/**
	 * ConcurrentHashMap should me used
	 * HashMap getObject can cause in an infinite loop in some JDKs
	 */
	private Map<String,Object> map = new HashMap<String,Object>();

    public synchronized void put(String key, Object value){
        map.put(key,value);
    }

    public Object get(String key){
        // can cause in an infinite loop in some JDKs!!
        return map.get(key);
    }
    
    private static MyCache fillCache(int i) {
    	MyCache cache = new MyCache();
    	for (int x=0; x<i; x++) {
    		cache.put("key_"+x, x);
		}
    	return cache;
    }
}