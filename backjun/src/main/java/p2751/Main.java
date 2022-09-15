package p2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[] value = new int[count];
		for(int i=0; i<count; i++)
			value[i] = Integer.parseInt(br.readLine());
		
		List<Integer> list = new LinkedList<>();
		list.add(0, value[0]);
		
		for(int i=1; i<count; i++) {
			for(int j=0; j<list.size(); j++) {
				if(value[i]<(int)list.get(j)) {
					list.add(j,value[i]);
					break;
				}else if(j==(list.size()-1)) {
					list.add(j+1,value[i]);
				}
			}
		}
		for(int i=0; i<count; i++) {
			bw.write(String.valueOf(list.get(i)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
