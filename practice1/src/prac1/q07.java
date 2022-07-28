package prac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class q07 {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\server\\git\\java\\practice1\\src\\Message.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("welcome1"));
		System.out.println(prop.getProperty("welcome2","Test"));
		System.out.println(prop.getProperty("welcome3"));
	}

}
