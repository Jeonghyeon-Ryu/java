package prac1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class q71 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("win","try","best","luck","do");
		Predicate<String> test1 = w-> {
			System.out.println("Checking...");
			return w.equals("do");
		};
	}
}
