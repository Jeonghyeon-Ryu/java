package com.yedam.java.ch1002;

public class MainTest {
	public static void main(String[] args) {
		try {						//원래 실행하고자 하는 코드.
		} catch (Exception e) { 	//예외 발생 시 실행되는 코드.
		} finally {					//정상적으로 실행하든 예외가 발생하든 반드시 실행되어야 하는 코드
		}
		
		String data1 = null;
		String data2 = null;
		
		try {
			int value1 = Integer.parseInt(data1);
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 오류 : " + e.toString());
		} catch (NumberFormatException e) {
			System.out.println("숫자 포멧 오류 : " + e.toString());
		} catch (Exception e) {
			System.out.println("그 밖에 오류 : " + e.toString());
		} finally {
			System.out.println("Try-Catch문 종료 ");
		}
		System.out.println("메인 종료");
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			errorControll(e);
		} catch (Exception e) {
			errorControll(e);
		}
	}
	// 거의 Throws 하는 경우가 많다. 불러주는 쪽에서 에러 처리방식을 결정하는 경우기 많기때문.
	public static void findClass() throws ClassNotFoundException, ArrayIndexOutOfBoundsException {
		Class c = Class.forName("java.lang.String");
		String[] s = new String[3];
		String a = s[5];
		System.out.println(a);
	}
	
	private static void errorControll(Exception e) {
		System.out.println("에러 : " + e.toString());
	}
}
