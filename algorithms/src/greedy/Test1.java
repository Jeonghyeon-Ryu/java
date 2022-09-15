package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] cArr = br.readLine().toCharArray();
		int result = cArr[0]-48;
		
		for(int i=1; i<cArr.length; i++) {
			if(result==0 || cArr[i]==0 || cArr[i]==1) {
				result += (cArr[i]-48);
			} else {
				result *= (cArr[i]-48);
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
