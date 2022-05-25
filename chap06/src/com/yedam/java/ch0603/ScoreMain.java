package com.yedam.java.ch0603;

import java.io.IOException;
import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) throws InterruptedException, IOException {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
//		ScoreProgram sp = new ScoreProgram();
		StudentsManagement st = StudentsManagement.getInstance();
		
		while(run) {
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("| 1.학생등록 | 2.점수입력 | 3.학생수 | 4.점수리스트 | 5.분석 | 6.종료 |");
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
			System.out.print("입력 > ");
			
			switch(sc.nextInt()) {
			case 1:		// 학생 등록
				System.out.println();
				System.out.print("이름을 입력하세요. > ");
				Student student = st.inputStudent(String.valueOf(sc.nextInt()));
				if(student.getNumber()>0) {
					System.out.println("학생 등록이 완료되었습니다.");
				} else {
					System.out.println("등록실패 !! 이미 등록된 학번입니다.");
				}
				break;
			case 2:
				System.out.println();
				System.out.print("학번과 점수를 입력하세요. > ");
				int n = sc.nextInt();
				int s = sc.nextInt();
				if(sp.inputScores(n, s)) {
					System.out.println("점수 등록이 완료되었습니다.");
				} else {
					System.out.println("등록실패 !! 등록되지 않은 학생입니다.");
				}
				break;
			case 3:
				System.out.println();
				sp.printStudentNum();
				break;
			case 4:
				System.out.println();
				sp.printScores();
				break;
			case 5:		// **************** 등록된거 하나도 없을때 추가 필요
				System.out.println();
				sp.analyzeScores();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				Thread.sleep(2000);
				run=false;
				sp.exit();
				break;
			default :
				System.out.println("잘못 입력하였습니다.");
				Thread.sleep(2000);
			}
		}
		sc.close();
	}
}
