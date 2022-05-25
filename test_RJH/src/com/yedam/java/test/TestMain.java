package com.yedam.java.test;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		boolean run = true;
		int currentIndex = -1;
		int size=-1;
		Scanner sc = new Scanner(System.in);
		StudentSystem ss = new StudentSystem();
		
		while(run) {
			System.out.println("=== 1.학생수 입력  2.학생정보 등록  3.학생정보 전체조회  4.학생정보 분석  5.종료 ===");
			System.out.print("선택 > ");
			
			switch(sc.nextLine()) {
			case "1":
				System.out.print("학생 수 > ");
				size=Integer.parseInt(sc.nextLine());
				ss.setStudentListSize(size);
				break;
			case "2":
				while(++currentIndex<size) {
					System.out.print("학번 > ");
					int number = Integer.parseInt(sc.nextLine());
					System.out.print("이름 > ");
					String name = sc.nextLine();
					System.out.print("점수 > ");
					int score = Integer.parseInt(sc.nextLine());
					ss.setStudentInfo(currentIndex,number,name,score);
				}
				break;
			case "3":
				ss.getStudentsInfo();
				break;
			case "4":
				System.out.println("최고 점수 : "+ ss.getMaxScore().getScore()+", 학번 : "+ss.getMaxScore().getNumber());
				System.out.println("최저 점수 : "+ ss.getMinScore().getScore()+", 학번 : "+ss.getMinScore().getNumber());
				System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점 입니다.\n",ss.getAverage());
				break;
			case "5":
				System.out.println("프로그램 종료");
				run=false;
				break;
			}
		}
	}
}
