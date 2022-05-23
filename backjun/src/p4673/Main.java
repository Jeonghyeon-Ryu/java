package p4673;

public class Main {
	public static void main(String[] args) {
		int[] n = new int[10001];
		int selfNum = 0;
		
		for(int i=1; i<=10000; i++) {
			if(i<10) {
				selfNum = i + i;
			} else if(i<100) {
				selfNum = i + i/10 + i%10;
			} else if(i<1000) {
				selfNum = i + i/100 + (i/10-i/100*10) + i%10;
			} else if(i<10000) {
				selfNum = i + i/1000 + (i/100-i/1000*10) + (i/10-(i/100-i/1000*10)*10-i/1000*100) + i%10;
			} else {
				selfNum = 10000+1;
			}
			
			if(selfNum<=10000) {
				n[selfNum] = 1;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(n[i]==0)
				System.out.println(i);
		}
	}
}
