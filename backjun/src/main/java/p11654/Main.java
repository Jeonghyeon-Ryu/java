package p11654;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String val = sc.nextLine();
		char result = val.charAt(0);
		System.out.print((int)result);
		sc.close();
	}
}
