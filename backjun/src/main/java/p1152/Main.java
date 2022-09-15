package p1152;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		
		value=value.trim();
		String[] result = value.split(" ");
		
		if(value.equals("")) {
			System.out.println("0");
		}else {
			System.out.println(result.length);
		}
		sc.close();
	}
}
