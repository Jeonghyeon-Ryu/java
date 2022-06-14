package com.yedam.java.ch1402;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("test4.db");
		while(true) {
			int data = reader.read();
			if(data==-1) break;
			System.out.println((char)data);
		}
		reader.close();
		System.out.println("-------------------------------- 바이트 기반 파일 읽기 ( 가능 )");
		reader = new FileReader("test2.db");
		while(true) {
			int data = reader.read();
			if(data==-1) break;
			System.out.println(data);
		}
		reader.close();
		System.out.println("-------------------------------- 문자 기반 파일 배열크기만큼씩 읽기");
		reader = new FileReader("test5.db");
		char[] buffer = new char[100];
		while(true) {
			int readCharNum = reader.read(buffer);
			if(readCharNum == -1) break;
			for(int i=0; i<readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		reader.close();
		System.out.println("-------------------------------- ");
		reader = new FileReader("test7.db");
		int readCharNum = reader.read(buffer,2,9);
		for(int i=0; i<5+readCharNum; i++) {
			System.out.print(buffer[i]);
		}
		System.out.println();
		reader.close();
		
	}

}
