package com.yedam.java.ch1102;

import java.util.Calendar;
import java.util.Date;

public class WrapTest {

	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		
		// boxing
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf("100");
		Integer obj3 = 100;	// 자동 박싱
		
		// Unboxing
		int val2 = obj2.intValue();
		int val3 = obj3; 	// 자동 언박싱
		
		int result = obj2 + val3;
		System.out.println("result : " + result);
		
		Integer object1 = 300;
		Integer object2 = 300;
		
		System.out.println(" == : " + (object1==object2));
		System.out.println(" equals : " + object1.equals(object2));
		System.out.println(" Unboxing : " + (object1.intValue()==object2.intValue()));
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.SECOND));
		Date date = new Date();
		System.out.println(date.getTime());
	}
}
