package p1546;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX=0;
		double AVG;
		double SUM=0;
		int n = sc.nextInt();
		int[] score = new int[n];
		for(int i=0; i<n; i++) {
			score[i] = sc.nextInt();
			if(MAX<score[i])
				MAX=score[i];
		}
		for(int i=0; i<n; i++) {
			SUM += (double)score[i]/MAX*100;
		}
		AVG = SUM / n;
		System.out.println(AVG);
	}
}
