package com.yedam.java.ch0701_GuessNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GameSystem extends Observer implements Runnable {
	static Scanner sc = new Scanner(System.in);
	static List<Integer> list = new ArrayList<Integer>();
	static int num;
	static int myNum;
	static int upDown=0;
	static int running=0;
	
	public void run() {
		menuPrint();
		int menuNo = menuSelect();
		if(menuNo==1) {
			login();
		}else if (menuNo==2) {
			signUp();
		}else if (menuNo==3) {
			exit();
		}
	}
	
	
	private void menuPrint() {
		System.out.println("=============== 메인 화면 ===============");
		System.out.println("1. 게임시작");
		System.out.println("2. 전적보기");
		System.out.println("3. 종료");
		System.out.println("=======================================");
	}
	private int menuSelect() {
		System.out.println("입력 > ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void gameRun() {
		running = 1;
		do {
			if(running==0 || list.size()==10) {
				break;
			}
			System.out.println("-  숫자를 맞춰보세요  -");
			System.out.println("------------------");
			if(list.size()!=0) {
				System.out.println("[ 현재까지 입력한 수 ]");
				outputMyNumber();
			}
			System.out.print("\n정답을 맞춰보세요 > ");
			myNum = Integer.parseInt(sc.nextLine());
			if(myNum>100 || myNum < 1) {
				System.out.println("잘못된 숫자를 입력하였습니다.");
				continue;
			}
			list.add(myNum);
			process();
			consoleReflash();
			if(upDown<0) {
				System.out.println("------------------");
				System.out.println("-      Down      -");
				System.out.println("------------------");
			} else if(upDown>0) {
				System.out.println("------------------");
				System.out.println("-       Up       -");
				System.out.println("------------------");
			} else if(upDown==0) {
				System.out.println("*******정답*******");
				reStart();
			}
		} while (true);
		sc.close();
	}
	public void init() {
		num = (int)(Math.random()*100+1);
	}
	public void reStart() {
		int var;
		Scanner sc = new Scanner(System.in);
		System.out.println("- [0] 종료");
		System.out.println("- [1] 재시작");
		System.out.print("- 입력 : ");
		var = Integer.parseInt(sc.nextLine());
		
		if(var==0) {
			running=0;
		} else {
			reset();
			consoleReflash();
		}
		sc.close();
	}
	public void process() {
		if(myNum<num) {
			upDown=1;
		} else if(myNum>num) {
			upDown=-1;
		} else if(myNum==num) {
			upDown=0;
		}
	}
	public void outputMyNumber() {
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(" "+iter.next());
		}
	}
	public void reset() {
		num = (int)(Math.random()*100+1);
		list.removeAll(list);
	}
	public void consoleReflash() {
		for(int i=0; i<4; i++) { System.out.println(""); }
	}
}
