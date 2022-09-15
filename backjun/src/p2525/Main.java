package p2525;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h=sc.nextInt();
		int m=sc.nextInt();
		int time=sc.nextInt();
		
		if(time>=60) {
			h += time/60;
			time %= 60;
		} 
		m += time;
		if(m>=60) {
			h = h + m/60;
			m %= 60;
		}
		if(h>=24) { h-=24; }
		System.out.print(h+" "+m);
		sc.close();
	}
}
