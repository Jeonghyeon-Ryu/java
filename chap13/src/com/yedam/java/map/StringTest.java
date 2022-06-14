package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("류정현",	85);
		map.put("홍길동", 90);
		map.put("동장군", 70);
		
		System.out.println("총 Entry 수 : " + map.size());
		
		Integer returnVal = map.put("홍길동", 99);
		if(returnVal != null) {
			System.out.println("Update, 기존 값 : " + returnVal);			
		}
		map.forEach((t, u) -> System.out.println("ForEach Key - " + t + " : " + u));
		System.out.println("---------------------------- Iterator");
		Set<String> keySet = map.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Integer value = map.get(key);
			System.out.println("Iterator Key - " + key + " : " + value);
		}
		System.out.println("---------------------------- 향상된 for 문");
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println("Key - " + key + " : " + value);
		}
		
		System.out.println("---------------------------- EntrySet");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> en = iter.next();
			System.out.println(en + " | " + "Key - " + en.getKey() + " : " + en.getValue());
		}
	}

}
