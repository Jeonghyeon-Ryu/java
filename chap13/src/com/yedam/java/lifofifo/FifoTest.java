package com.yedam.java.lifofifo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) throws IOException {
		Queue<String> que = new LinkedList<>();
		File file = new File("C:\\Users\\admin\\git\\java\\chap13\\src\\argText.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		
		// FileInputStream 테스트
//		System.out.println(fis.readAllBytes());
		
		// InputStreamReader 테스트
		System.out.println(Character.toChars(isr.read()));
		
		// Queue 멤버 추가
		while((line=br.readLine()) != null) {
			que.offer(line);
		}
		
		que.forEach( s -> System.out.println(s));
		br.close();
	}

}
