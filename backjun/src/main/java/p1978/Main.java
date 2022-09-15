package p1978;

import java.util.Scanner;

public class Main {
	public static boolean prime(int number) {
		if(number==2)
			return true;
        if(number < 2)
            return false;
        if(number%2==0)
        	return false;
        
        for (int i=3; i<=number/2; i+=2) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int min = Integer.parseInt(sc.nextLine());
    	int max = Integer.parseInt(sc.nextLine());
    	int sum=0;
    	int minResult=0;
    	
    	for(int i=min; i<=max; i++) {
    		if(prime(i)) {
    			sum+=i;
    			if(minResult==0) {
    				minResult=i;
    			}
    			if(minResult>i) {
    				minResult=i;
    			}
    		}
    	}
    	if(sum!=0) {
        	System.out.println(sum);
        	System.out.println(minResult);
    	} else {
    		System.out.println("-1");
    	}
    	sc.close();
    }
}
