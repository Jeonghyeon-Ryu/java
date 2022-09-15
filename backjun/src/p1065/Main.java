package p1065;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		int result = 0;
		String tmp;
		
		if(count < 100) {
			result = count;
		} else {
			result=99;
			for(int i=100; i<=count; i++) {
				tmp = String.valueOf(i);
				if((tmp.charAt(0)-tmp.charAt(1))==(tmp.charAt(1)-tmp.charAt(2)))
					result++;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
