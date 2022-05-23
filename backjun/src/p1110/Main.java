package p1110;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String initString = sc.nextLine();
		char[] c = new char[2];
		int count=0;
		if(initString.length()==1)
			initString='0'+initString;
		String s = initString;
		
		do {
			c[0] = s.charAt(0);
			c[1] = s.charAt(1); 
			
			int sum = (c[0]-48)+(c[1]-48);
			sum = sum%10;
			
			s = String.valueOf(c[1]-48)+String.valueOf(sum);
			count++;
		} while(!initString.equals(s)); 
		
		System.out.println(count);
		sc.close();
	}
}
