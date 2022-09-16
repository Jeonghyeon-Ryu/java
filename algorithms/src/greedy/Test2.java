package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int i = count-1;
		count = 0;
		while(true) {
//			i = i - (st.nextToken()-'0');
			count++;
			if(i < 0) {
				break;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
