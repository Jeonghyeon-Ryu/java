package calc;

import java.util.Stack;

public class Calculator {

	int bracketCount;
	static String strInit; // 입력 받은 수식
	Stack<Character> rearStack = new Stack<>();
	Stack<Character> tmpStack = new Stack<>();
	Stack<Integer> intStack = new Stack<>();
	
	// 생성자
	Calculator(String sc){
		this.strInit = sc;
		this.bracketCount = 0;
	}
	
	// 후위 연산자 변경 메소드
	void convertRearOperator() {
		char[] strMid = strInit.toCharArray();
				
		for(int i=0; i<strMid.length; i++) {
			if(47<strMid[i] && strMid[i]<58) { // 숫자면
				rearStack.push(strMid[i]);
			} else {
				if(strMid[i]=='(') {
					tmpStack.push(strMid[i]);
					bracketCount++;
				} else if(strMid[i]==')') {
					while(tmpStack.peek()!='(') {
						rearStack.push(tmpStack.pop());
					}
					tmpStack.pop();
					bracketCount--;
				} else if(strMid[i]=='*'||strMid[i]=='/') {
					if(tmpStack.isEmpty()) {
						tmpStack.push(strMid[i]);
					} else if(tmpStack.peek()=='+'||tmpStack.peek()=='-') {
						tmpStack.push(strMid[i]);
					} else {
						rearStack.push(tmpStack.pop());
						tmpStack.push(strMid[i]);
					}
				} else if(strMid[i]=='+'||strMid[i]=='-') {
					if(tmpStack.isEmpty()||tmpStack.peek()=='(') {
						tmpStack.push(strMid[i]);
					} else {
						while(!tmpStack.isEmpty()) {
							rearStack.push(tmpStack.pop());
						}
						tmpStack.push(strMid[i]);
					}
						
				}
				
			}
		}
		while(!tmpStack.isEmpty()) {
			rearStack.push(tmpStack.pop());
		}
	
		for(int i=0; i<rearStack.size(); i++) {
			System.out.println(rearStack.elementAt(i));
		}
	}
	
	// 후위 연산 변경위한 스택 연산
	void stackRearOper(boolean mulFlag, boolean addFlag) {
		
	}
	
	void operator() {
		for(int i=0; i<rearStack.size(); i++) {
			if(47<rearStack.elementAt(i)&&rearStack.elementAt(i)<58) {
				intStack.push(rearStack.elementAt(i)-48);
			} else {
				int left,right;
				char oper = rearStack.elementAt(i);
				right=intStack.pop();
				left=intStack.pop();
				switch(oper){
				case '+':
					intStack.push(add(left,right));
					break;
				case '-':
					intStack.push(sub(left,right));
					break;
				case '*':
					intStack.push(mul(left,right));
					break;
				case '/':
					intStack.push(div(left,right));
					break;
				}
			}
		}
		System.out.println("결과 : " + intStack.peek());
	}
	
	int add(int a, int b) {
		return a+b;
	}
	
	int sub(int a, int b) {
		return a-b;
	}
	
	int mul(int a, int b) {
		return a*b;
	}
	
	int div(int a, int b) {
		return a/b;
	}
}
