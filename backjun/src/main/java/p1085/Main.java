package p1085;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int min;
        int value[] = new int[4];

        for (int i =0; i < value.length; i++)
        	value[i] = sc.nextInt();

        value[2] -= value[0];
        value[3] -= value[1];

        min = value[0];

        for (int i=1;i<value.length;i++)
            if (value[i] < min)
                min = value[i];

        System.out.println(min);
        sc.close();
	}
}
