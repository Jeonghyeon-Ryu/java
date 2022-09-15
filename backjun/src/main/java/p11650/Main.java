package p11650;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		List<int []> list=new ArrayList<int[]>();
		for(int i=0;i<n;i++) {
			String [] strArr=sc.nextLine().split(" ");
			int[] numint= {Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1])};
			list.add(numint);
		}
		
		Collections.sort(list, (s1,s2)-> {
			return (s1[0]!=s2[0])?Integer.compare(s1[0], s2[0]):Integer.compare(s1[1], s2[1]);
		});

		for (int[] intArr : list) {
			System.out.println(intArr[0]+" "+intArr[1]);
		}
		sc.close();
	}
}
