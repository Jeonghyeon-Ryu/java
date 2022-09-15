package p11720;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length=Integer.parseInt(sc.nextLine());
		String value=sc.nextLine();
		int sum=0;
		
		for(int i=0; i<length; i++) {
			 sum+= Character.getNumericValue(value.charAt(i));
		}
		System.out.println(sum);
		sc.close();
	}
}
