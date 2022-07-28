package prac1;

import java.util.stream.Stream;

public class q86 {
	public static void main(String[] args) {
		Stream.of("Java", "Unix", "Linux").filter(s->s.contains("n")).peek(s->System.out.println("PEEK: " + s)).findAny();
	}
}
