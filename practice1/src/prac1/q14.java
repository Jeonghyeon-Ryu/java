package prac1;

import java.util.Optional;

public class q14 {
	public static void main(String[] args) {
		Address address = null;
		Optional<Address> add = Optional.ofNullable(address);
		Employee el = new Employee(add);
		String eAddress = (add.isPresent())?add.get().getCity():"City Not Available";
		System.out.println(eAddress);
	}
}

class Employee {
	Optional<Address> address;
	
	Employee(Optional<Address> address) {
		this.address = address;
	}
	public Optional<Address> getAddress() {
		return address;
	}
}

class Address {
	String city ="New York";
	public String getCity() { 
		return city;
	}
	public String toString() {
		return city;
	}
}