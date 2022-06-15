package com.yedam.java.emp;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<Employee> list = EmpDAO.getInstance().selectAll();
		
		list.forEach( x -> System.out.println(x.toString()));
		System.out.println();
		System.out.println(EmpDAO.getInstance().selectOne(149).toString());
		System.out.println();
		EmpDAO.getInstance().insert(new Employee());
		EmpDAO.getInstance().update(new Employee());
		EmpDAO.getInstance().delete(1000);
	}
}
