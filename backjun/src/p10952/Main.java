package p10952;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if(a!=0 && b!=0) {
				bw.write(String.valueOf(a+b));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}

