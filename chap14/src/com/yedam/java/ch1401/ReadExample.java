package com.yedam.java.ch1401;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("test.db");
		
		while(true) {
			int data = is.read();
			if(data == -1)
				break;
			System.out.println(data);
		}
		is.close();
		System.out.println("------------------- 2바이트씩 읽기");
		is = new FileInputStream("test2.db");
		byte[] buffer = new byte[100];
		while(true) {
			int readByteNum = is.read(buffer);
			if(readByteNum == -1) break;
			for(int i=0; i<readByteNum; i++)
				System.out.println(buffer[i]);
			System.out.println();
		}
		is.close();
		System.out.println("------------------- 파일 읽은것 특정 지점부터 붙여서 읽기");
		is = new FileInputStream("test3.db");
		int readByteNum = is.read(buffer,3,2);
		for(int i=0; i<3+readByteNum; i++) {
			System.out.println(buffer[i]);
		}
		System.out.println();
		is.close();
		
	}
}
