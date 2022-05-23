package p2941;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInit = sc.nextLine();
		String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for(int i=0; i<cro.length; i++) {
			strInit = strInit.replace(cro[i], "#");
		}
		
		System.out.println(strInit.length());
		sc.close();
	}
}
