package p11021;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<n; i++) {
			String[] s = sc.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			bw.write("Case #"+(i+1)+": "+(a+b));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
