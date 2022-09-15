package p2292;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		int count=1;
		
		while(true) {
			if(count==1)
				sum=1;
			else 
				sum = sum + 6*(count-1);
			if(sum<n)
				count++;
			else
				break;
		}
		System.out.println(count);
		sc.close();
	}
}
