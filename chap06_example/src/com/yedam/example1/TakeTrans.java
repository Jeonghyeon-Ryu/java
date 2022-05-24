package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000);
		Subway green = new Subway("2호선", 1500);
		Bus yellow = new Bus("3호선", 1000);
		
		hong.take(green);
		
		hong.showInfo();
		green.showInfo();
		System.out.println();
		hong.take(yellow);
		hong.showInfo();
		yellow.showInfo();
	}

}
