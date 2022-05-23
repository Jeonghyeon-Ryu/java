package p10951;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// Scanner 이용 
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			bw.write(String.valueOf(Integer.parseInt(s[0])+Integer.parseInt(s[1])));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		sc.close();
		
		// Buffer 이용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String input;
//		while((input=br.readLine()) != null) {
//			String result = input.split(" ");
//			int a = Integer.parseInt(result[0]);
//			int b = Integer.parseInt(result[1]);
//			bw.write(String.valueOf(a+b));
//			bw.newLine();
//		}
//		bw.flush();
//		bw.close();
	}
}
