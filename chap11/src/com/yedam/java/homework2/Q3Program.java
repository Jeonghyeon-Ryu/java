package com.yedam.java.homework2;

import java.util.Scanner;

public class Q3Program {
	boolean run = true;
	Keypad game;
	Scanner sc = new Scanner(System.in);
	
	public Q3Program() {
		randomGame();
		while(run) {
			printMenu();
			switch(selectMenu()) {
			case 1:
				game.leftUpButton();
				continue;
			case 2:
				game.leftDownButton();
				continue;
			case 3:
				game.rightUpButton();
				continue;
			case 4:
				game.rightDownButton();
				continue;
			case 5:
				game.changeMode();
				continue;
			case 0:
				changeGame();
				continue;
			case 9:
				System.out.println("EXIT");
				run=false;
			}
		}
	}
	void randomGame() {
		int i =(int)Math.floor((Math.random()*2));
		if(i==0) {
			game = new RPGgame();
		} else {
			game = new ArcadeGame();
		}
	}
	void changeGame() {
		if(game.getClass()==RPGgame.class) {
			game = new ArcadeGame();
		} else if(game.getClass()==ArcadeGame.class) {
			game = new RPGgame();
		} else {
			System.out.println("선택된 게임이 없어 무작위로 선택됩니다.");
			randomGame();
		}
	}
	void printMenu() {
		System.out.println("============================================================================================");
		System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println("============================================================================================");
	}
	
	int selectMenu() {
		System.out.print("choice >> ");
		return Integer.parseInt(sc.nextLine());
	}
}
