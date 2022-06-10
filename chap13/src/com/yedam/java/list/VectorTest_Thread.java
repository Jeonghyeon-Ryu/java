package com.yedam.java.list;

import java.util.List;
import java.util.stream.Stream;

public class VectorTest_Thread extends Thread{
	private List<Integer> list;
	
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		Stream<Integer> st = list.stream();
		st.forEach(x -> System.out.println(Thread.currentThread().getName() + " : " +x));
	}
}


