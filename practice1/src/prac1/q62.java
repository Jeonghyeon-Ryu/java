package prac1;

import java.util.Arrays;
import java.util.List;

public class q62 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java","Java EE","Java SE");
//		boolean b = list.stream().findAny().get().equals("Java");
		boolean b = list.stream().anyMatch(w->w.equals("Java"));
//		boolean b = list.stream().findFirst().get().equals("Java");
//		boolean b = list.stream().allMatch(w->w.equals("Java"));
		System.out.println(b);
	}
}
