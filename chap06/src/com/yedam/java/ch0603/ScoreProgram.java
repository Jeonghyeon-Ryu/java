package com.yedam.java.ch0603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ScoreProgram {
	// [___________필드_____________]
	private Map<Integer, Integer> scores = new HashMap<>();
	private File file = new File("D:\\dev\\workspace\\chap06\\src\\com\\yedam\\java\\ch0603\\Students.txt");
	
	// [___________생성자_____________]
	ScoreProgram() throws IOException {
		String line;
		String[] tmp = new String[2];
		if(!file.exists()) {
			file.createNewFile();
		} else {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			while((line=br.readLine()) != null) {
				tmp = line.split(" ");
				scores.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			}
			br.close();
			
		}
	}
	// 1. 학생 등록
	boolean inputStudent(int numStudent) throws IOException {
		if(scores.containsKey(numStudent)) {
			return false;
		}else {
			scores.put(numStudent, 0);
			
			return true;
		}
	}
	// 2. 점수입력 
	boolean inputScores(int num, int score) {
		if(scores.containsKey(num)) {
			scores.put(num,score);
			return true;
		}
		else  {
			return false;
		}
	}
	// 3. 학생수 출력
	void printStudentNum() {
		System.out.println("총 학생 수 : " + scores.size() + " 명");
	}
	// 4. 점수리스트 출력
	void printScores() {
		try {
			Set<?> set = scores.entrySet();
			Iterator<?> iter = set.iterator();
			while(iter.hasNext())
				System.out.println(iter.next());
		} catch(NullPointerException e) {
			e.toString();
		}
	}
	// 5. 분석 - 최고점수, 평균점수
	void analyzeScores() {
		Entry<Integer, Integer> MAX;
		Entry<Integer, Integer> MIN;
		double AVG, AVG2;
		int sum=0;
		MAX = Collections.max(scores.entrySet(),Map.Entry.comparingByValue());
		MIN = Collections.min(scores.entrySet(),Map.Entry.comparingByValue());
		Iterator<Integer> iter = scores.values().iterator();
		while(iter.hasNext())
			sum+=(int)iter.next();
		if(scores.size()>2) {
			AVG2 = (sum-MAX.getValue()-MIN.getValue())/(double)(scores.size()-2);
			AVG = sum/(double)scores.size();
			
			System.out.println("최고점수 받은 학생 : " + MAX);
			System.out.println("최소점수 받은 학생 : " + MIN);
			System.out.printf("전체 평균점수 : %.2f\n", AVG);
			System.out.printf("최고/최저 점수 제외 평균 : %.2f\n", AVG2);
		} else {
			System.out.println("");
		}
	}
	// 6. 종료 -> 파일에 저장
	void exit() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(int key : scores.keySet()) {
			bw.write(String.valueOf(key)+" "+String.valueOf(scores.get(key)));
			bw.newLine();
		}
		bw.flush();	
		bw.close();
		fos.close();
	}
	// 7. 데이터베이스 연결
	void connectDB() {
		
	}
}
