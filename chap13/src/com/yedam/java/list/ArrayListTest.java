package com.yedam.java.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
		
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.indexOf("Database"));
		
		System.out.println("------------ Iterator");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("------------ Stream");
		Stream<String> st = list.stream();
		st.sorted().forEach(x -> System.out.println(x));
		
	}

}
