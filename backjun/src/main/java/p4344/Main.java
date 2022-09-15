package p4344;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineNum = sc.nextInt();
		List<Integer> scores = new ArrayList<>();
		int sum=0;
		int biggerAvg=0;
		for(int i=0; i<lineNum; i++) {
			int scoreNum = sc.nextInt();
			for(int j=0; j<scoreNum; j++) {
				scores.add(sc.nextInt());
				sum+=scores.get(j);
			}
			for(int j=0; j<scoreNum; j++) {
				if(scores.get(j)>(sum/scoreNum))
					biggerAvg++;
			}
			double result = Math.round((double)biggerAvg/(double)scoreNum*100*1000)/1000.0;
			System.out.printf("%.3f%%\n",result);
			sum=0;
			biggerAvg=0;
			scores.clear();
		}
		sc.close();
	}
}
