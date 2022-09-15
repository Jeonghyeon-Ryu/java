package pTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
			List<Country> couList =Arrays.asList(new Country("Japan", Country.Continent.ASIA), new Country("Italy", Country.Continent.EUROPE), new Country("Germany",Country.Continent.EUROPE));
			Map<Country.Continent, List<String>> regionNames = couList.stream().collect(Collectors.groupingBy(Country::getRegion, Collectors.mapping(Country::getName, Collectors.toList())));
			System.out.println(regionNames);
	}
	
//	static void doStuff() throws ArithmeticException, NumberFormatException, Exception{
//		if(Math.random() > -1) throw new Exception("try again");
//	}
//	
//	public void m1() {
//		System.out.println("m1");
////		throw new E1();	// Exception은 컴파일 시점에 오류로 인식됨.
//	}
//	public void m2() {
//		System.out.println("m2");
//		throw new E2();	// Runtime Exception 은 컴파일 시점에 오류가 아님
//	}
//	
//	static void test1() {
////		Employee e1 = new Employee();
//		Employee e2 = new Employee("Jack", 50);
//		Employee e3 = new Employee("Chloe", 40 , 5000);
//		
////		e1.print();
//		e2.print();
//		e3.print();
//		
//		String[][] str = new String[1][];
//		str[0] = new String[5];
//		
//		System.out.println(str.length);
//		System.out.println(str[0].length);
//	}
}
class Country{
	public enum Continent {ASIA, EUROPE}
	String name;
	Continent region;
	
	public Country(String na, Continent reg) {
		name = na;
		region = reg;
	}
	public String getName() { return name; }
	public Continent getRegion() { return region; }
}



//class Vehicle {
//	int x;
//	Vehicle(){
//		this(10);
//	}
//	Vehicle(int x) {
//		this.x = x;
//	}
//}
//class Car extends Vehicle{
//	int y;
//	Car() {
//		super();
////		this(20);
//	}
//	Car(int y){
//		this.y=y;
//	}
//}
//
//class E1 extends Exception{}
//class E2 extends RuntimeException {}
//class Employee{
//	private String name ;
//	private int age;
//	private int salary;
//	
//	public Employee(String name, int age) {
//		this.name = name;
//		this.age=age;
//		this.salary = 2000;
//	}
//	public Employee(String name, int age, int salary) {
//		this(name,age);	// super, this 생성자는 무조건 첫줄에 와야함. ( 생성자 이름으로 호출불가 )
//		this.salary=salary;
//	}
//	public void print() {
//		System.out.println(name + " : " + age + " : " + salary);
//	}
//}
//
//class Person {
//	String name;
//	int age;
//	
//	public Person(String n, int a) {
//		name = n;
//		age = a;
//	}
//	public String getName() {
//		return name;
//	}
//	public int getAge() {
//		return age;
//	}
//}
//
//public static void checkAge(List<Person> list, Predicate<Person> predicate) {
//	for(Person p : list) {
//		if(predicate.test(p)) {
//			System.out.println(p.name + " ");
//		}
//	}
//}