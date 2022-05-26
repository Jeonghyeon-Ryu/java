package com.yedam.java.ch0702;

public class DriverTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Vehicle vehicle = bus;
		Vehicle vehicle2 = new Vehicle();
		
		driver.drive(new Bus());
		driver.drive(new Texi());
		driver.drive(new Vehicle());
		
		bus.print();
		System.out.println(vehicle instanceof Bus);
		System.out.println(vehicle2 instanceof Bus);
	}

}
