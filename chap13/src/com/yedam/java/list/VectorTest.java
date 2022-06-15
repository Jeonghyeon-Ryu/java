package com.yedam.java.list;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>();
		List<Integer> vector = new Vector<>();
		
		VectorTest_Thread t1 = new VectorTest_Thread();
		t1.setList(vector);
		t1.start();
		
		VectorTest_ThreadB t2 = new VectorTest_ThreadB();
		t2.setList(vector);
		t2.start();
		
	}

}
