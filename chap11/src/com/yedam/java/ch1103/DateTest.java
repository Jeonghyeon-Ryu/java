package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");

		String result = sdf.format(new Date());
		
		System.out.println(result);
		
	}

}
