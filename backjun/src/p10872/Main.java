package p10872;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fac(sc.nextInt()));
	}
	public static int fac(int n) {
		if(n>0) n=n*fac(n-1);
		else
			n=1;
		return n;
	}
}
