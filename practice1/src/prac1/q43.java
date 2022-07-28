package prac1;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class q43 {
	public static void main(String[] args) {
		UnaryOperator<Double> uol = s -> s * 2;
		List<Double> loanValues = Arrays.asList(1000.0, 2000.0);
		loanValues.stream().filter(lv -> lv >= 1500).map(lv -> uol.apply(lv)).forEach(s -> System.out.print(s + " "));
	}
}
