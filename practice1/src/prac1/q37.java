package prac1;

public class q37 {
	public static void main(String[] args) throws Exception {
		Vehicle1 v = new Solar();
		v.ride();
	}
}

class Fuel extends Exception {}
class Vehicle1 { 
	void ride() throws Exception {
		System.out.println("Happy Journey!");
	}
}

class Solar extends Vehicle1 {
	public void ride() throws Exception {
		super.ride();
	}
}