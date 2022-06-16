package com.yedam.java.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeptSystem {
	private DeptDAO dao = DeptDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public DeptSystem() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴선택
			int menuNo = selectMenu();
			// 기능실행
			if(menuNo == 1) {			// insert
				insertDepartment();
			} else if(menuNo == 2) {	// update
				updateDepartment();
			} else if(menuNo == 3) {	// delete
				deleteDepartment();
			} else if(menuNo == 4) {	// selectAll
				selectOneDepartment();
			} else if(menuNo == 5) {	// selectOne
				selectAllDepartment();
			} else if(menuNo == 9) {	// 종료
				exit();
				break;
			} else {	// 에러
				inputError();
			}
		}
	}
	private void menuPrint() {
		System.out.println("==============================================");
		System.out.println(" 1.등록  2.수정  3.삭제  4.부서조회  5.전체조회  9.종료");
		System.out.println("==============================================");
	}
	private int selectMenu() {
		int menuNo=0;
		try {
			System.out.print("메뉴 선택 > ");
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("잘못된 메뉴를 입력하였습니다.");
		}
		return menuNo;
	}
	private void exit() {
		System.out.println("부서 시스템을 종료합니다.");
	}
	private void inputError() {
		System.out.println("잘못 입력하였습니다. 메뉴 번호를 확인해주세요.");
	}
	private void insertDepartment() {
		Department dept = new Department();
		dept = inputAll();
		dao.insert(dept);
	}
	private void updateDepartment() {
		Department dept = new Department();
		dept = inputUpdateInfo();
		dao.update(dept);
	}
	private void deleteDepartment() {
		int deptId = inputDeptId();
		dao.delete(deptId);
	}
	private void selectAllDepartment() {
		List<Department> list = new ArrayList<>();
		list = dao.selectAll();
		list.forEach(x -> System.out.println(x));
	}
	private void selectOneDepartment() {
		int deptId = inputDeptId();
		System.out.println(dao.selectOne(deptId));
	}
	private Department inputAll() {
		Department dept = new Department();
		System.out.print("부서 번호 > ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서 이름 > ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("상사 > ");
		dept.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));
		
		return dept;
	}
	private Department inputUpdateInfo() {
		Department dept = new Department();
		System.out.print("부서 번호 > ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서 이름 > ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		
		return dept;
	}
	private int inputDeptId() {
		System.out.print("부서 번호 > ");
		return Integer.parseInt(sc.nextLine());
	}
}
