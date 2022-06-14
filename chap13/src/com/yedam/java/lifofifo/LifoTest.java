package com.yedam.java.lifofifo;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class LifoTest {

	public static void main(String[] args) {
		Stack<String> box = new Stack<>();
		
		System.out.println("넣은 값 : " + box.push("1 : 100") );
		System.out.println("넣은 값 : " + box.push("2 : 50") );
		System.out.println("넣은 값 : " + box.push("3 : 10") );
		System.out.println("넣은 값 : " + box.push("4 : 500") );
		System.out.println("Box 크기 : " + box.size());
		System.out.println();
		while(!box.isEmpty()) {
			System.out.println("꺼낸 값 : " + box.pop());
		}
		System.out.println("Box 크기 : " + box.size());
	}

}
