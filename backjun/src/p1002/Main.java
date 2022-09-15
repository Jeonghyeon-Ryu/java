package p1002;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(sc.nextLine());
		int count=0;
		do {
			String s = sc.nextLine();
			String[] c = s.split(" ");
						
			double length = Math.sqrt((double) Math.pow(Integer.parseInt(c[3])-Integer.parseInt(c[0]),2)
					+(double)Math.pow(Integer.parseInt(c[4])-Integer.parseInt(c[1]),2));
			double div = Double.parseDouble(c[2])+Double.parseDouble(c[5]);
			
			if((Double.parseDouble(c[0])==Double.parseDouble(c[3]))&&(Double.parseDouble(c[1])==Double.parseDouble(c[4])&&(Double.parseDouble(c[2])==Double.parseDouble(c[5])))) {
				bw.write("-1");		// 두 원 일치
				bw.newLine();
			} else if(length > div) {
				bw.write("0");
				bw.newLine();
			} else if(Math.abs(Double.parseDouble(c[2])-Double.parseDouble(c[5]))>length) {
				bw.write("0");
				bw.newLine();
			} else if(Math.abs(Double.parseDouble(c[2])-Double.parseDouble(c[5]))==length) {
				bw.write("1");
				bw.newLine();
			} else if(Math.abs(Double.parseDouble(c[2])+Double.parseDouble(c[5]))==length) {
				bw.write("1");
				bw.newLine();
			} else {
				bw.write("2");
				bw.newLine();
			}
			count++;
		}while(count<n);
		bw.flush();
		bw.close();
		sc.close();
	}
}

