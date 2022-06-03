package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = {72, 101, 108, 108, 111 ,32, 74, 97, 118, 97};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, bytes.length-6);
		System.out.println(str2);
		
		StringBuilder sb = new StringBuilder(str2);
		System.out.println(sb);
		sb.append(5);
		System.out.println(sb);
		
		// String -> byte -> String
		System.out.println();
		String strs1 = "안녕하세요";
		byte[] bytes1 = strs1.getBytes();
		System.out.println(bytes1);
		String strs2 = new String(bytes1);
		System.out.println(strs2);
		
		byte[] bytes2 = strs1.getBytes("EUC-KR"); 
		System.out.println(bytes2);
		String strs3 = new String(bytes2,"EUC-KR");
		System.out.println(strs3);
		System.out.println();
		
		// charAt
		String ssn = "001024-1245323";
		char gender = ssn.charAt(7);
		switch(gender) {
		case '1': case '3':
			System.out.println("남자입니다.");
			break;
		case '2': case '4':
			System.out.println("여자입니다.");
			break;
		default:
			System.out.println("중성입니다.");
		}
		for(int i=0; i<ssn.length(); i++)
			System.out.println(ssn.charAt(i));
		
		String val1 = "신민철";
		String val2 = new String("신민철");
		String val3 = new String("신민철");
		System.out.println(val2 == val3);
		System.out.println(val1.equals(val3));
		
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		if(subject.indexOf("자바")>=0) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련 없는 책");
		}
		
		// substring
		System.out.println("--------- substring");
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		
		String ssn1 = "882352=1242353";
		System.out.println("생년월일 : "+ ssn1.substring(0,6));
		System.out.println("개별정보 : "+ ssn1.substring(7));
		
		// length
		String[] temp = {"1", "2", "3"};
		System.out.println(temp.length);
		System.out.println(temp[0].length());
		
		// replace
		String oldStr = "Java 프로그래밍 Java";
		
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + " -> " + newStr);
	}
}
