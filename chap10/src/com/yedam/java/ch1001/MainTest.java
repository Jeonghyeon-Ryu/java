package com.yedam.java.ch1001;

public class MainTest {

	public static void main(String[] args) {
		// 실행예외 -> 문법적으로 문제가 없고 실제 실행 시 발생하는 예외
		
		// NullPointerException
		try {
			String data = null;
			System.out.println(data.toString());
		} catch (Exception e) {
			System.out.println("에러 : " + e.toString());
		}
		
		
		// ArrrayIndexOutOfBoundsException
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
		} catch (Exception e) {
			System.out.println("에러 : " + e.toString());
		}
		
		// NumberFormatException : 문자를 숫자로 바꿀때 많이 일어남.
		try {
			String data3 = "100";
			String data4 = "a100";
			
			int value1 = Integer.parseInt(data3);
			int value2 = Integer.parseInt(data4);
			int result = value1 + value2;
			
		} catch (Exception e) {
			System.out.println("에러 : " + e.toString());
		}
		
		// ClassCastException
		try {
			changeDog(new Cat());
		} catch (Exception e) {
			System.out.println("에러 : " + e.toString());
		}
	}
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {
			Dog dog = (Dog) animal;
		}
	}
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

