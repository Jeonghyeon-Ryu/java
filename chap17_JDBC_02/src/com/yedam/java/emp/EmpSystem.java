package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpSystem {
	private EmpDAO dao = EmpDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public EmpSystem() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if(menuNo == 1) {
				//등록
				insertEmployee();
			} else if (menuNo==2) {
				//수정
				updateEmployee();
			} else if (menuNo==3) {
				//삭제
				deleteEmployee();
			} else if (menuNo==4) {
				//사원 조회(단건조회)
				selectEmployee();
			} else if (menuNo==5) {
				//전체 조회
				selectAllEmployee();
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
		System.out.println(" 1.등록  2.수정  3.삭제  4.사원조회  5.전체조회  9.종료");
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
	private void insertEmployee() {
		// 사원정보 입력
		Employee emp = inputAll();
		// DB 전달
		dao.insert(emp);
	}
	private void updateEmployee() {
		// 수정하는 정보 입력
		Employee emp = inputUpdateInfo();
		// DB 전달
		dao.update(emp);
	}
	private void deleteEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB전달
		dao.delete(employeeId);
	}
	private void selectEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB전달
		Employee emp = dao.selectOne(employeeId);
		// 결과 출력
		if(emp!=null) {
			System.out.println(emp);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}
	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll();
		
		list.forEach(x -> System.out.println(x));
	}
	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사원번호 > ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.print("이름 > ");
		emp.setFirstName(sc.nextLine());
		System.out.print("성 > ");
		emp.setLastName(sc.nextLine());
		System.out.print("이메일 > ");
		emp.setEmail(sc.nextLine());
		System.out.print("전화번호 > ");
		emp.setPhoneNumber(sc.nextLine());
		System.out.print("입사일(YYYY-MM-DD) > ");
		emp.setHireDate(Date.valueOf(sc.nextLine()));
		System.out.print("직급 > ");
		emp.setJobId(sc.nextLine());
		System.out.print("연봉 > ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		System.out.print("상여 > ");
		emp.setCommissionPct(Double.parseDouble(sc.nextLine()));
		System.out.print("상사 > ");
		emp.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서 > ");
		emp.setDepartmentId(Integer.parseInt(sc.nextLine()));
		
		return emp;
	}
	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		System.out.print("사원번호 > ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.print("연봉 > ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		
		return emp;
	}
	private int inputEmployeeId() {
		System.out.print("사원번호 > ");
		return Integer.parseInt(sc.nextLine());
	}
}
