package com.yedam.java.example2;

public interface Access {
	// 저장소에 대해 사용 방법을 정의
	// 등록
	public void insert(Student studnet);
	// 수정
	public void update(Student student);
	// 삭제
	public void delete(Student student);
	// 전체조회
	public Student[] selectAll();
	// 단건조회
	public Student selectOne(int studentId);
}
