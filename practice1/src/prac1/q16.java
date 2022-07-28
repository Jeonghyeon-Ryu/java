package prac1;

import java.util.Set;
import java.util.TreeSet;

public class q16 {
	public static void main(String[] args) {
		Set<Vehicle> vehicles = new TreeSet<>();
		vehicles.add(new Vehicle(10123,"Ford"));
		vehicles.add(new Vehicle(10124,"BMW"));
		System.out.println(vehicles);
	}
}
class Vehicle {
	int vno;
	String name;
	
	public Vehicle(int vno, String name) {
		this.vno = vno;
		this.name = name;
	}
	public String toString() {
		return vno + " : " + name;
	}
}
