package prac1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class q107 {

	public static void main(String[] args) {
		List<Emp>li = Arrays.asList(new Emp("Sam", 20), new Emp("John", 60), new Emp("Jim", 51));
		Predicate<Emp> agVal = s -> s.getEAge() <= 60; //line n1
		li = li.stream().filter(agVal).collect(Collectors.toList());
		
		Stream<String> names = li.stream().map(Emp::getEName); //line n2
		names.forEach(n -> System.out.print(n + " "));
	}

}

class Emp {
	private String eName;
	private Integer eAge;

	Emp(String eN, Integer eA) {
		this.eName = eN;
		this.eAge = eA;
	}

	public Integer getEAge() {
		return eAge;
	}

	public String getEName() {
		return eName;
	}
}