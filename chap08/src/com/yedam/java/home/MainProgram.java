package com.yedam.java.home;

import java.util.Scanner;

public class MainProgram {
	Scanner sc = new Scanner(System.in);
	BookProgram bp = new BookSystem();
	BookAccess ba = BookRepo.getInstance();
	
	public MainProgram() {
		while(true) {
			bp.printMenu();
			int menuNum = bp.inputMenuNum();
			if(menuNum == 1) {
				bp.inputBook(ba);
			} else if (menuNum == 2) {
				bp.printAllBook(ba);
			} else if (menuNum == 3) {
				bp.printBook(ba);
			} else if (menuNum == 4) {
				bp.printRepot(ba);
			} else if (menuNum == 5) {
				bp.exit();
				break;
			}
		}
	}
}
