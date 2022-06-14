package com.yedam.java.set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StringTest {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\dev\\workspace\\chap13\\src\\argText.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		Set<String> set = new TreeSet<>();
		
		// Set 멤버 추가
		while((line=br.readLine()) != null) {
			set.add(line);
		}
		set.add(new String("Java"));
		
		System.out.println("Size : " + set.size());
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println("\t Element : " + iter.next());
		}
		
		set.remove("Java");
//		set.clear();
		
		System.out.println("Size : " + set.size());
		set.forEach(x -> System.out.println("\t Element : " + x));
		br.close();
	}
}
