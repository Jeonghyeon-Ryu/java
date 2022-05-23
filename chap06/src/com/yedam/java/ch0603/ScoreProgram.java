package com.yedam.java.ch0603;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ScoreProgram {
	// [ 필드 ]
	int numStudents;
	private Map<Integer, Integer> scores = new HashMap<>();
	
	//0. 생성자

	//1. 학생수 출력
	void printStudentNum() {
		System.out.println(scores.size());
	}
	//2. 점수입력
	void inputScores(int num, int score) {
		scores.put(num,score);
	}
	//3. 점수리스트 출력
	void printScores() {
		try {
			Set set = scores.entrySet();
			Iterator iter = set.iterator();
			while(iter.hasNext())
				System.out.println(iter.next());
		} catch(NullPointerException e) {
			e.toString();
		}
	}
	//4. 분석 - 최고점수, 평균점수
	void analyzeScores() {
		Entry<Integer, Integer> MAX;
		double AVG;
		int sum=0;
				
		MAX = Collections.max(scores.entrySet(),Map.Entry.comparingByValue());
		Iterator iter = scores.values().iterator();
		while(iter.hasNext())
			sum+=(int)iter.next();
		
		AVG = sum/scores.size();
		
		System.out.println("최고점수 받은 학생 : " + MAX);
		System.out.println("전체 평균점수 : " + AVG);
	}
	//5. 학생 등록
	boolean inputStudent(int numStudent) throws IOException {
		File file = new File("D:\\dev\\workspace\\chap06\\src\\com\\yedam\\java\\ch0603\\Students.txt");
		if(!file.exists())
			file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
		
		if(scores.containsKey(numStudent)) {
			return false;
		}
		else {
			scores.put(numStudent, 0);
			System.out.println(scores.get(numStudent));
			bw.write(numStudent); // ************************** 변경하여야함 
			bw.newLine();
			bw.flush();
			bw.close();
			return true;
		}
	}
}
