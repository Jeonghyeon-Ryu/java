package p1929;

import java.util.Scanner;

public class Main {
	public static boolean prime(int number) {
		if(number==2)
			return true;
        if(number < 2)
            return false;
        if(number%2==0)
        	return false;
        
        for (int i=3; i<=Math.sqrt(number); i+=2) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int min = sc.nextInt();
    	int max = sc.nextInt();
    	
    	for(int i=min; i<=max; i++) {
    		if(prime(i)) {
    			System.out.println(i);
    		}
    	}
    	sc.close();
    }
}
