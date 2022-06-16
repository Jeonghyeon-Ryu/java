package com.yedam.java.emp;

import java.util.List;
import java.util.Scanner;

public class LocSystem {
	private LocDAO dao = LocDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public LocSystem() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if(menuNo == 1) {
				//등록
				insertLocation();
			} else if (menuNo==2) {
				//수정
				updateLocation();
			} else if (menuNo==3) {
				//삭제
				deleteLocation();
			} else if (menuNo==4) {
				//사원 조회(단건조회)
				selectLocation();
			} else if (menuNo==5) {
				//전체 조회
				selectAllLocation();
			} else if (menuNo==9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println("==============================================");
		System.out.println(" 1.등록  2.수정  3.삭제  4.지역조회  5.전체조회  9.종료");
		System.out.println("==============================================");
	}
	private int selectMenu() {
		int menu = 0;
		System.out.print("메뉴선택 > ");
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
			//menu = Integer.parseInt(sc.nextLine());
		}
		return menu;
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void inputError() {
		System.out.println("메뉴에 맞는 번호를 입력해주세요.");
	}
	private void insertLocation() {
		// 사원정보 입력
		Location loc = inputAll();
		// DB 전달
		dao.insert(loc);
	}
	private void updateLocation() {
		// 수정하는 정보 입력
		Location loc = inputUpdateInfo();
		// DB 전달
		dao.update(loc);
	}
	private void deleteLocation() {
		// 사원번호 입력
		int locId = inputLocationId();
		// DB전달
		dao.delete(locId);
	}
	private void selectLocation() {
		// 사원번호 입력
		int locId = inputLocationId();
		// DB전달
		Location loc = dao.selectOne(locId);
		// 결과 출력
		if(loc!=null) {
			System.out.println(loc);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}
	private void selectAllLocation() {
		List<Location> list = dao.selectAll();
		
		list.forEach(x -> System.out.println(x));
	}
	private Location inputAll() {
		Location loc = new Location();
		System.out.print("지역 > ");
		loc.setLocationId(Integer.parseInt(sc.nextLine()));
		System.out.print("주소 > ");
		loc.setStreetAddress(sc.nextLine());
		System.out.print("성 > ");
		
		return loc;
	}
	private Location inputUpdateInfo() {
		Location loc = new Location();
		System.out.print("지역번호 > ");
		loc.setLocationId(Integer.parseInt(sc.nextLine()));
		System.out.print("주소 > ");
		loc.setStreetAddress(sc.nextLine());
		System.out.print("우편번호 > ");
		loc.setPostalCode(sc.nextLine());
		System.out.println("도시명 > ");
		loc.setCity(sc.nextLine());
		System.out.println("주 이름 > ");
		loc.setStateProvince(sc.nextLine());
		System.out.println("국가 > ");
		loc.setCountryId(sc.nextLine());;
		
		return loc;
	}
	private int inputLocationId() {
		System.out.print("지역번호 > ");
		return Integer.parseInt(sc.nextLine());
	}
}
