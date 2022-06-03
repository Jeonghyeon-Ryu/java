package com.yedam.java.ch1102;

public class StringTest2 {
	public static void main(String[] args) {
		// toLowerCase & toUpperCase
		System.out.println("----------------> toLowerCase & toUpperCase");
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";
		if(str1.equals(str2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		System.out.println("---toLowerCase 변환 후 비교");
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		if(val1.equals(val2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		System.out.println("---equalsIgnoreCase 사용");
		if(str1.equalsIgnoreCase(str2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		// trim
		System.out.println();
		System.out.println("----------------> trim");
		String subject = "           자바    프로그래밍          ";
		String newData = subject.trim();
		System.out.println(newData);
		
		String a = newData.substring(newData.indexOf("자바"), newData.indexOf("자바")+2) 
				+" "+ 
				newData.substring(newData.indexOf("프로그래밍"), newData.indexOf("프로그래밍")+5);
		System.out.println(a);
		
		String b = newData.replace(" ", "");
		b = b.replace("자바", "자바 ");
		System.out.println(b);
		
		// valueOf
		System.out.println();
		System.out.println("----------------> valueOf");
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		String value4 = "" + 10.5;
		
		System.out.println(value1 + " " + value2 + " " + value3 + " " + value4);
	}
}
