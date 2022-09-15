package p10809;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		int[] count = new int[26];
		
		
		
		for(int i=0; i<26; i++) {
			count[i] = value.indexOf(String.valueOf((char)(i+97)));
		}
		for(int i=0; i<26; i++) {
			System.out.print(count[i]+" ");
		}
		sc.close();
	}
}
