package prac1;

import java.util.function.BiFunction;

public class q41 {
	public static void main(String[] args) {
		BiFunction<Integer, Double, Double> val = (t1,t2) -> t1 + t2;
		System.out.println(val.apply(10, 10.5));
	}
}
