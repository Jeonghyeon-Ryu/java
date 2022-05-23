package p1316;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countLine = Integer.parseInt(sc.nextLine());
		int[] flag = new int[28];
		char chTmp=' ';
		boolean isGrp=true;
		int count = 0;
		
		for(int n=0; n<countLine; n++) {
			String strInit = sc.nextLine();
			for(int i=0; i<strInit.length(); i++) {
				if(strInit.charAt(i)!=chTmp) {
					chTmp = strInit.charAt(i);
					flag[strInit.charAt(i)-97] += 1;
				}
			}
			
			for(int i=0; i<28; i++) {
				if(flag[i]>1)
					isGrp=false;
				flag[i]=0;
			}
			if(isGrp)
				count++;
			isGrp=true;
			chTmp = ' ';
		}
		System.out.println(count);
		sc.close();
	}
}
