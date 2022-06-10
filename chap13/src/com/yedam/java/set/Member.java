package com.yedam.java.set;

public class Member{
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		Member temp = null;
		if(obj instanceof Member) {
			temp = (Member)obj;
		}
			
		return ((this.name.equals(temp.name))&&(this.age==temp.age));
	}

	
}
