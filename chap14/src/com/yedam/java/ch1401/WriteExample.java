package com.yedam.java.ch1401;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws IOException {
//		File file = new File("test.db");
//		if(!file.exists())
//			file.createNewFile();
		byte a = 10;
		byte b = 20;
		byte c = 127;
		
		// 한 바이트씩 넣기
		OutputStream os = new FileOutputStream("test.db");
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush();
		os.close();
		
		
		// 배열 바이트 넣기
		os = new FileOutputStream("test2.db");
		
		byte[] array = {50,60,80};
		os.write(array);
		os.flush();
		os.close();
		
		
		// 배열 바이트 인덱스 지정해서 넣기
		os = new FileOutputStream("test3.db");
		
		byte[] array2 = {10,20,30,40,50};
		os.write(array2,3,2);
		os.flush();
		os.close();
	}

}
