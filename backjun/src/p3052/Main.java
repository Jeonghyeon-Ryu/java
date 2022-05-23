package p3052;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[10];
		int[] flag = new int[42];
		int count=0;
		
		for(int i=0; i<10; i++) {
			n[i] = sc.nextInt()%42;
		}
				
		for(int i=0; i<10; i++) {
			flag[n[i]]+=1;
		}
		for(int i=0; i<42; i++) {
			if(flag[i]>0)
				count++;
		}
		System.out.println(count);
		sc.close();
	}
}
