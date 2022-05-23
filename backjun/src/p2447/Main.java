package p2447;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		print(n,n);
	}
	public static void print(int x, int y) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if((i==1&&j==1)||(x==1&&y==1)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
					
				}
//				print(x)
			}
			System.out.println();
		}
	}
}
