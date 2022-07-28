package prac1;

import java.util.Optional;

public class q66 {
	public static void main(String[] args) {
		Optional<String> c1 = getCountry("Paris");
		Optional<String> c2 = getCountry("Las Vegas");
		System.out.println(c1.orElse("Not Found"));
		if(c2.isPresent()) {
			c2.ifPresent(x->System.out.println(x));
		} else {
			System.out.println(c2.orElse("Not Found"));
		}
	}
	
	public static Optional<String> getCountry(String loc) {
		Optional<String> couName = Optional.empty();
		if("Paris".equals(loc)) {
			couName = Optional.of("France");
		} else if ("Mumbai".equals(loc)) {
			couName = Optional.of("India");
		}
		return couName;
	}
}
