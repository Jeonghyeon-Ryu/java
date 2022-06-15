package com.yedam.java.ch1403;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamExample {

	public static void main(String[] args) throws Exception {
		// BufferedStream 없는경우
		String originalFilePath1 = BufferedStreamExample.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "C:\\Users\\admin\\git\\java\\chap14\\src\\com\\yedam\\java\\ch1403\\targetFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		long nonBufferTime = copy(fis1,fos1);
		System.out.println("버퍼 사용 안할 경우 : " + ((double)nonBufferTime/1000000000) + " 초");
		
		// BufferedStream 있는경우
		String originalFilePath2 = BufferedStreamExample.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "C:\\Users\\admin\\git\\java\\chap14\\src\\com\\yedam\\java\\ch1403\\targetFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		long BufferTime = copy(bis,bos);
		System.out.println("버퍼 사용 할 경우 : " + ((double)BufferTime/1000000000) + " 초");
	}
	
	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		
		while(true) {
			data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		
		long end = System.nanoTime();
		return (end-start);
	}
}
