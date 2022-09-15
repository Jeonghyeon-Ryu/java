package p5622;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] setNum = { 3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10,11 } ;
		String strInit = sc.nextLine();
		char[] strMid = new char[strInit.length()];
		int[] result = new int[strInit.length()];
		int sum = 0;
		
		for(int i=0; i<strInit.length(); i++) {
			strMid[i] = strInit.charAt(i);
			result[i] = setNum[strMid[i] - 65];
		}
		for(int i : result)
			sum+=i;
		
		System.out.println(sum);
		sc.close();
	}
}
