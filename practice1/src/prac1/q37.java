package prac1;

public class q37 {
	public static void main(String[] args) throws Exception {
		Vehicle v = new Solar();
		v.ride();
	}
}

class Fuel extends Exception {}
class Vehicle { 
	void ride() throws Exception {
		System.out.println("Happy Journey!");
	}
}

class Solar extends Vehicle {
	public void ride() throws Exception {
		super.ride();
	}
}