package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {
		System.out.println("pi : " + Planet.pi);
//		Planet.pi = Math.pi;
		
		Planet earth = new Planet(6400);
		System.out.println("earth : " + Planet.radius);
		Planet moon = new Planet(1400);
		System.out.println("moon : " + Planet.radius);
		
		earth.getArea();
		moon.getArea();
	}

}
