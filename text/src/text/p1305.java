package text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class p1305 {
	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, String> map = new HashMap<>();
		Scanner sc = new Scanner(new File("stringsss.txt"));
		int count=1;
		
		while(sc.hasNext()) {
			map.put(count, sc.next());
			count++;
		}
		System.out.println("총 Entry 수 : " + map.size());

		Set<Integer> keySet = map.keySet();
		Iterator<Integer> keyIter= keySet.iterator();
		
		while(keyIter.hasNext()) {
			int key = keyIter.next();
			String value = map.get(key);
			System.out.println("Key : "+key+" | Value : " + value );
		}
		
		map.remove(3);
		System.out.println("총 Entry 수 : " + map.size());
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> entryIter = entrySet.iterator();
		
		while(entryIter.hasNext()) {
			Map.Entry<Integer, String> entry = entryIter.next();
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key : "+key+" | Value : " + value );
		}
		map.clear();
		System.out.println("총 Entry 수 : " + map.size());
	}
}
