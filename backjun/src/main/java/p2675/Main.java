package p2675;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		int num;
		String temp;
		
		String[] result = new String[value];
		
		for(int i=0;i<value;i++) {
			num = sc.nextInt();
			temp = sc.next();
			result[i]="";
			for(int j=0;j<temp.length();j++) {
				for(int k=0;k<num;k++) {
					result[i]=result[i]+temp.charAt(j);
				}
			}
		}
		for (String string : result) {
			System.out.println(string);
		}
		sc.close();
	}
}
