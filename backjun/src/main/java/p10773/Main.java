package p10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k, sum;
        k = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        sum = 0;

        for (int i = 0; i < k; i++){
            int n = sc.nextInt();

            if (n != 0) { stack.push(n); }
            else { stack.pop(); }
        }

        if (stack.isEmpty()) {System.out.print(0);}
        else {
            while (stack.size()> 0) sum += stack.pop();
            System.out.print(sum);
        }
        sc.close();
    }
}
