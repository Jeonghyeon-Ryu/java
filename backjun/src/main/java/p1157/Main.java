package p1157;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		int[] countEng = new int[29];
		
		value = value.toLowerCase();
		for(int i=0; i<value.length(); i++) {
			countEng[(int)value.charAt(i)-96]++;
		}
		int result=0;
		int error=0;
		for(int i=1; i<=28; i++) {
			if(countEng[result]<countEng[i]) {
				result=i;
				error=0;
			}else if(result!=0 && countEng[result]==countEng[i]) {
				error++;
			}
		}
		if(error!=0)
			System.out.println("?");
		else
			System.out.println((char)(result+64));
		sc.close();
	}
}
