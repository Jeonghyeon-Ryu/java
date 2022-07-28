package prac1;

import java.util.Arrays;
import java.util.List;

public class q77 {
	public static void main(String[] args) {
		List<Integer> prices = Arrays.asList(3,4,5);
		prices.stream().filter(e -> e>4).peek(e->System.out.print("Price " + e)).map(n -> n-1).forEach (n -> System.out.println (" New Price " + n));
//		.peek(n -> System.out.println(" New Price " + n ));
	}
}
