package p10818;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		String sInit = sc.nextLine();
		String[] sMid = sInit.split(" ");  
		
		int MAX = Integer.parseInt(sMid[0]);
		int MIN = MAX;
		
		for(int i=1; i<count; i++) {
			if(MAX<Integer.parseInt(sMid[i]))
				MAX = Integer.parseInt(sMid[i]);
		}
		for(int i=1; i<count; i++) {
			if(MIN>Integer.parseInt(sMid[i]))
				MIN = Integer.parseInt(sMid[i]);
		}
		System.out.println(MIN + " " + MAX);
		sc.close();
	}
}
