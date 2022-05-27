package com.yedam.java.example2;

public class StudentRepo implements Access {
	// =================== 싱글톤 필드 및 메소드
	private static StudentRepo instance = new StudentRepo();
	public static StudentRepo getInstance() {
		return instance;
	}

	// =================== 필드
	private Student[] dataList;
	private int listIndex;
	
	// =================== 생성자
	private StudentRepo() {
		init();
	}
	
	
	// =================== 메소드
	private void init() {
		dataList = new Student[100];
		listIndex = -1;
	}
	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
	}

	@Override
	public void update(Student student) {
		for(int i=0; i<=listIndex; i++) {
			if(student.getId()==dataList[i].getId()) {
				dataList[i]=student;
			}
		}
	}

	@Override
	public void delete(Student student) {
		for(int i=0; i<=listIndex; i++) {
			if(student.getId()==dataList[i].getId()) {
				dataList[i]=null;
			}
		}
		
		cleanDataList();
	}
	private void cleanDataList() {
		// 기존 데이터 -> 임시변수
		Student[] tempList = dataList;
		int tempIndex=0;
		// 기존 필드 초기화
		init();
		// 임시변수에서 데이터만 기존 필드로 복사
		for(int i=0; i<=tempIndex; i++) {
			if(tempList[i]!=null) {
				dataList[++listIndex] = tempList[i];
			}
		}
		
	}

	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex+1];
		for(int i=0; i<=listIndex; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Student selectOne(int studentId) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId()==studentId) {
				return dataList[i];
			}
		}
		return null;
	}
}
