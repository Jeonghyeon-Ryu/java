/*
 * 	고객센터, 전화상담, 상담원
	고객센터 전화오면 대기열에 저장
	상담원이 지정되기 전까지 대기상태로
	각 전화를 상담원에게 배분
	1. 순서대로 배분
	2. 짧은 대기열(소요시간) 위주
	3. 고객의 우선순위에 따라 배분
 */

package com.yedam.java.example1;

import java.util.Scanner;

public class SchedulerSystem {
	public static void main(String[] args) {
		// 변수
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("전화 상담 할당 방식을 선택합니다.");
			System.out.println("R : 한명씩 차례로 할당");
			System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
			System.out.println("P : 우선 순위가 높은 고객에게 먼저 할당");
			System.out.println("E : 종료");
			
			System.out.print("Setting > ");
			String ch = sc.next();
			
			Scheduler scheduler = null;
			if("R".equals(ch)||"r".equals(ch)) {
				scheduler = new RoundRobin();
			} else if("L".equals(ch)||"l".equals(ch)) {
				scheduler = new LeastJob();
			} else if("P".equals(ch)||"p".equals(ch)) {
				scheduler = new PriorityAllocation();
			} else if("E".equals(ch)||"e".equals(ch)) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("지원되지 않는 기능입니다.");
			}
			if(scheduler!=null) {
				scheduler.getNextCall();
				scheduler.sendCallToAgent();
			}
			
			System.out.println();
			
		}
	}
}
