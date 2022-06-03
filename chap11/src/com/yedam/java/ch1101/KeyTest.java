package com.yedam.java.ch1101;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {

	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<>();
		
		map.put(new Key(1), "홍길동");
		// Map 에서 Key 비교는
		// 1. equals + 2. hashCode 비교함.
		String value = map.get(new Key(1));
		System.out.println(value);
	}

}
