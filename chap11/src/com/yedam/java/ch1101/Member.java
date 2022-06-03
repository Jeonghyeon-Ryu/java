package com.yedam.java.ch1101;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한지 판별
		// 1. 동일한 타입인지 판별
		// 2. 내부 필드값 동일한지 판별
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(this.id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return this.id;
	}
	
	
}
