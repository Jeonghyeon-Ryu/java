package com.yedam.java.ch0604;

import java.util.Stack;

public class Calculator {
	static int leftValue;
	static int rightValue;
	static boolean countOperator;
	static Stack stack;
	static char oper;
	
	Calculator() {
		leftValue = 0;
		rightValue = 0;
		countOperator = false;
		stack = new Stack();
		oper = ' ';
	}
	void numberProcess(String st) {
		for(int i=0; i<st.length(); i++) {
			if(st.charAt(i)=='+'||st.charAt(i)=='-'||st.charAt(i)=='*'||st.charAt(i)=='/'||st.charAt(i)=='('||st.charAt(i)==')') {
				
			}
		}
	}
	void stackProcess(String st) throws InterruptedException {
		boolean bracketFlag = false;
		boolean mulOperFlag = false;
		
		if(st.toLowerCase().equals("exit")) {
			System.out.println("정상 종료 되었습니다.");
			Thread.sleep(2000);
			return;
		} else {
			for(int i=0; i<st.length(); i++) {
				if(47<st.charAt(i)&&st.charAt(i)<57)
				
			}
		}
	}
	public static void process(String st) {
		
		if(st.toLowerCase().equals("exit")) {
			System.out.println("정상 종료 되었습니다.");
			return;
		} else {
			for(int i=0; i<st.length(); i++) {
				if(st.charAt(i)=='+' || st.charAt(i)=='-' || st.charAt(i)=='*' || st.charAt(i)=='/' || st.charAt(i)=='=') {
					operate();
					oper=st.charAt(i);
				} else {
					stack.push(st.charAt(i)); // 연산자 만날때까지 Stack PUSH
				}
			}
			// 마지막 = 안적었을 시 최종 숫자까지 연산
			if(stack.size()!=0) {
				operate();
			}
			System.out.println("결과 : " + leftValue);
		}
	}
	// 연산자 만나면 Stack POP
	static void operate() {
		if(countOperator==false) {				// 연산자를 한번도 안만났을 경우 왼쪽Value에 저장
			int stackSize = stack.size();
			countOperator = !countOperator;
			for(int j=0; j<stackSize; j++) {
				leftValue += Integer.parseInt(stack.pop().toString())*(int)Math.pow(10, j);
			}
		} else if(countOperator==true) {		// 연산자를 한번이라도 만났을 경우 오른쪽Value에 저장
			int stackSize = stack.size();
			for(int j=0; j<stackSize; j++) {
				rightValue += Integer.parseInt(stack.pop().toString())*(int)Math.pow(10, j);
			}
		}
		if(oper=='+') {			// operator
			leftValue = add(leftValue,rightValue);
		} else if(oper=='-') {			// operator
			leftValue = sub(leftValue,rightValue);
		} else if(oper=='*') {			// operator
			leftValue = multi(leftValue,rightValue);
		} else if(oper=='/') {			// operator
			leftValue = (int)div(leftValue,rightValue);
		}
	}
	// 덧셈 메소드
	public static int add(int... a) {
		int sum=0;
		for(int i:a) { sum+=i; }
		initValue();
		return sum;
	}
	// 뺄셈 메소드
	public static int sub(int... a) {
		int sub=0;
		for(int i:a) { sub-=i; }
		initValue();
		return sub+a[0]*2;
	}
	// 곱셈 메소드
	public static int multi(int... a) {
		int result=1;
		for(int i:a) { result*=i; }
		initValue();
		return result;
	}
	// 나눗셈 메소드
	public static double div(int... a) {
		double result = a[0];
		try {
			for(int i:a) { result/=i; }
		} catch (ArithmeticException e) {
			System.out.println("'0' 으로 나눌 수 없습니다. : " + e.toString());
			System.out.println("다시 입력해주세요.");
		}
		initValue();
		return result*a[0];
	}
	static void initValue() {
		leftValue = 0;
		rightValue = 0;
	}
}
