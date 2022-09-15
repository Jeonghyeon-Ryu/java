package p4153;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String value = sc.nextLine();
			
			if(!value.equals("0 0 0")) {
				String[] triangle = value.split(" ");
				for(int n=0;n<2;n++) {
					for(int i=0; i<2; i++) {
						int temp = Integer.parseInt(triangle[i]);
						if(temp>Integer.parseInt(triangle[i+1])) {
							triangle[i]=triangle[i+1];
							triangle[i+1]=String.valueOf(temp);
						}
					}
				}
				if((Math.pow(Double.parseDouble(triangle[2]),2))==(Math.pow(Double.parseDouble(triangle[0]),2)+Math.pow(Double.parseDouble(triangle[1]),2))) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			} else {
				break;
			}
		}
		sc.close();
	}
}
