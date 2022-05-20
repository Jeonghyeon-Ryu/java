package array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayTest {

	public static void main(String[] args) {
		String[] arr = {"hello","hi","good"};
	
		System.out.println("---------------------1");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------------------2");
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("---------------------3");
		Iterator iter = Arrays.asList(arr).iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("---------------------4");
		Stream<String> st = Arrays.stream(arr);
		st.forEach(s->System.out.println(s));
		System.out.println("---------------------끝");
	}
}
