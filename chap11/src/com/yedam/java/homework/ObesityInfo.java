package com.yedam.java.homework;

public class ObesityInfo extends StandardWeightInfo {

	public ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	@Override
	public void getInformation() {
		System.out.println(getName() + "님의 신장 "+ getHeight() + ", 몸무게 " + getWeight() + ", 표준체중 "+ determineObesity(getObesity()));
	}
	public double getObesity() {
		return (getWeight()-getStandardWeight())/getStandardWeight()*100;
	}
	public String determineObesity(double bmi) {
		String result=null;
		if(bmi<=18.5) {
			result = "저체중";
		} else if (18.5<bmi && bmi<23.0) {
			result = "정상";
		} else if (23.0<=bmi && bmi<25.0) {
			result = "과체중";
		} else if (25.0<=bmi) {
			result = "비만";
		} else {
			result = "BMI 측정 오류";
		}
		return result;
	}
}
