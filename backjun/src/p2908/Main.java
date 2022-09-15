package p2908;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInit = sc.nextLine();
		String[] strMid = strInit.split(" ");
		String[] strLast = new String[2];
		
		strLast[0] = String.valueOf(strMid[0].charAt(2)) + String.valueOf(strMid[0].charAt(1)) + String.valueOf(strMid[0].charAt(0));
		strLast[1] = String.valueOf(strMid[1].charAt(2)) + String.valueOf(strMid[1].charAt(1)) + String.valueOf(strMid[1].charAt(0));
		
		if(Integer.parseInt(strLast[0])>Integer.parseInt(strLast[1]))
			System.out.println(strLast[0]);
		else
			System.out.println(strLast[1]);
		sc.close();
	}
}
