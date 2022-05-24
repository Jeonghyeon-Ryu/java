package calc;

import java.util.Scanner;

public class CalMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Calculator cal = new Calculator(s);
		cal.convertRearOperator();
		cal.operator();
		
		sc.close();
	}
}
