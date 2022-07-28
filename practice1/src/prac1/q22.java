package prac1;

import java.util.Arrays;
import java.util.List;

public class q22 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Joe","Paul","Alice","Tom");
		System.out.println(list.stream().filter(x -> x.length()>3).count());
		System.out.println(list.stream().map(x -> x.length()>3).count());	// 4
//		System.out.println(list.stream().peek(x -> x.length()>3).count().get());
//		System.out.println(list.stream().filter(x -> x.length()>3).mapToInt(x -> x).count());
	}
}
