package p2753;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int year;
		Scanner sc = new Scanner(System.in);
		year = Integer.parseInt(sc.nextLine());
		if((year%4==0 && year%100!=0) || year%400==0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		sc.close();
	}
}
