package prac1;

import java.util.function.DoubleSupplier;

public class q54 {
	String name;
	Integer cost;
	q54(String name, Integer cost){
		this.name = name;
		this.cost = cost;
	}
	String getName() { return name; }
	int getCost() { return cost; }
	
	public static void main(String[] args) {
		q54 q1 = new q54("IT", null);
		DoubleSupplier qs1 = q1::getCost;
		System.out.println(q1.getName() + ":" + qs1.getAsDouble());
	}
}
