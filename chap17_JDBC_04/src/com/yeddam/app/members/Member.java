package com.yeddam.app.members;

public class Member {
	private String memberId;
	private String memberPw;
	// memberRole - 0:ADMIN , 1:USER
	private int memberRole;
	
	
	@Override
	public String toString() {
		String info = "";
		if(memberRole==0) {
			info = "[ 관리가 계정 : " + memberId + " ]";
		} else {
			info = "[ 일반 계정 : " + memberId + " ]";
		}
		return info;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public int getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(int memberRole) {
		this.memberRole = memberRole;
	}
	
	
}
