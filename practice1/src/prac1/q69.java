package prac1;

import java.util.Arrays;
import java.util.List;

public class q69 {

	public static void main(String[] args) {
		List<String> v = Arrays.asList("","Geo","","John","Ryu");
		Long newVal = v.stream().filter(x->!x.isEmpty()).count();
		System.out.println(newVal);
	}

}
