package p1712;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[3];
		int fee;
		int count=0;
		
		for(int i=0; i<3; i++)
			input[i] = sc.nextInt();
		fee=input[0];
		while((fee-(input[2]-input[1])*count)>0) {
			if(input[2]<=input[1]) {
				count = -1;
				break;
			}
			count++;
		}
		
		if((fee-(input[2]-input[1])*count)<0 && count>2100000000)
			System.out.println("-1");
		else if((fee-(input[2]-input[1])*count)==0)
			System.out.println(count+1);
		else
			System.out.println(count);
			
		sc.close();
	}
}
