package p2884;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		m = m-45;
		if(m<0) {
			h--;
			m += 60;
		}
		if(h<0) {
			h+=24;
		}
		System.out.print(h + " " + m);
		sc.close();
	}
}
