package com.yedam.java.ch1501;

public class Util{
	public static <T> BoxA<T> boxing(T t){
		BoxA<T> box = new BoxA<>();
		box.set(t);
		return box;
	}
	
	public static <K, V> boolean compare(Pair<K,V> p1,Pair<K,V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	public static <K, V> V printInfo(K key) {
		V v = null ;
		
		return v;
			
	}
}
