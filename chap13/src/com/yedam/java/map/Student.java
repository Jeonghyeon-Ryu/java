package com.yedam.java.map;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Student temp = null;
		if(obj instanceof Student) {
			temp = (Student)obj;
			return (temp.name.equals(this.name) && temp.sno==this.sno);
		}
		return false;
//		if(temp.name.equals(this.name) && temp.sno==this.sno ) {
//			return true;
//		} else {
//			return false;
//		}
	}
}
