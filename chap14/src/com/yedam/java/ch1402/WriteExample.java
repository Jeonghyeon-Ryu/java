package com.yedam.java.ch1402;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("test4.db");
		
		char a='a';
		char b='b';
		char c='c';
		
		writer.write(a);
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		
		//------------------ Char 배열 전부 내보내기
		writer = new FileWriter("test5.db");
		char[] arr1 = {'A','B','C'};
		writer.write(arr1);
		writer.flush();
		writer.close();
		
		//------------------ Char 배열 일부분 내보내기 
		writer = new FileWriter("test6.db");
		char[] arr2 = {'A','B','C','D','E'};
		writer.write(arr2,3,2);
		writer.flush();
		writer.close();
		
		//------------------ String 내보내기
		writer = new FileWriter("test7.db");
		String str1 = "ABCDE\n";
		String str2 = "abcde";
		writer.write(str1);
		writer.write(str2,2,3);
		writer.flush();
		writer.close();
	}

}
