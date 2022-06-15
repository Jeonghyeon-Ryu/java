package com.yedam.java.ch1403;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharacterConvertExample {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.print("입력문장 > ");
		String data = new Scanner(System.in).nextLine();
		write(data);
		System.out.println("-------- 출력 확인 ---------");
		read();
	}
	public static void write(String str) throws Exception {
//		FileWriter fw = new FileWriter("text1.txt");
//		fw.write(str);
//		fw.flush();
//		fw.close();
		
		OutputStream os = new FileOutputStream("text1.txt");
//		os.write(str); 
		
		Writer writer = new OutputStreamWriter(os);
		writer.write(str);
		writer.flush();
		writer.close();
		
//		OutputStreamWriter osr = new OutputStreamWriter(os);
//		osr.write(str);
//		osr.flush();
//		osr.close();
	}
	public static void read() throws Exception {
		char[] buffer = new char[100];
		int readCharNum;
		// 1. FileReader 이용하여 문자열로 읽기
//		FileReader fr = new FileReader("text1.txt");
//		readCharNum = fr.read(buffer);
//		fr.close();
		
		// 2. FileInputStream > InputStreamReader > Writer 이용하여 char로 읽기
		InputStream is = new FileInputStream("text1.txt");
		
		Reader reader = new InputStreamReader(is);
		readCharNum = reader.read(buffer);
		reader.close();
		
		// 3. FileInputStream  > InputStreamReader 이용하여 char로 읽기
//		InputStreamReader isr = new InputStreamReader(is);
//		readCharNum = isr.read(buffer);
//		isr.close();
		
		String data = new String(buffer,0,readCharNum);
		System.out.println(data);
	}
}
