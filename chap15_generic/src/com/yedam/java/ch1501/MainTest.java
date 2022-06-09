package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		bag.set(new Note());
		Note note = (Note)bag.get();
		
		bag.set("가나다");
		String name = (String)bag.get();
		
		System.out.println(note.getClass() + " " + name);
		
		System.out.println("----------------------");
		Box<Note, String, Integer> box = new Box<>();
		
		box.setT(new Note());
		box.setK(599);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int k = box.getK();
		String v = box.getV();
		
		System.out.println(memo.getClass() + " " + k + " " + v );
		System.out.println("-----------------------");
		
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setK(new Taxi());
		vehicle.setT(new Car());
		vehicle.setV(new Bus());
		System.out.println(vehicle.getK().getClass());
		System.out.println(vehicle.getT().getClass());
		System.out.println(vehicle.getV().getClass());
		
		
	}
}

class Car{}
class Bus{}
class Taxi{}