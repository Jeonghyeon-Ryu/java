package com.yedam.java.homework;

public class StandardWeightInfo extends Human {

	public StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	@Override
	public void getInformation() {
		System.out.println(getName() + "님의 신장 "+ getHeight() + ", 몸무게 " + getWeight() + ", 표준체중 "+ getStandardWeight());
	}
	public double getStandardWeight() {
		return (getHeight()-100)*0.9;
	}
}
