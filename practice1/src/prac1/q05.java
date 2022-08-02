package prac1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class q05 {

	public static void main(String[] args) throws IOException {
		String s = "아메리카노: 4500원 만두국 :5000원";
		char[] arr = s.toCharArray();
		int k=0;
		String result = "";
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) {
				result+=arr[i];
				list.add(result);
			}
			if(arr[i]!=' ') {
				result+=arr[i];
				continue;
			}
			if(++k==2) {
				list.add(result);
				k=0;
				result="";
			}
			
		}
		list.forEach(x->System.out.println(x));
	}
	

}
