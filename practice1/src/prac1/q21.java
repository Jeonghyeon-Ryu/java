package prac1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class q21 {
	public static void main(String[] args) {
		List<Book1> books = Arrays.asList(new Book1("Begin",2),new Book1("A Guide",3));
		Collections.sort(books, new Book1());
		System.out.println(books);
	}
}

class Book1 implements Comparator<Book1>{
	String name;
	double price;
	public Book1() {}
	public Book1(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public int compare(Book1 b1, Book1 b2) {
		return b1.name.compareTo(b2.name);
	}
	public String toString() {
		return name + " : " + price;
	}
}