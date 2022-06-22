package com.yeddam.app.members;

import com.yedam.app.common.DAO;

public class MembersDAO extends DAO{
	//싱글톤
	private static MembersDAO mDAO = null;
	private MembersDAO() {}
	public static MembersDAO getInstance() {
		if(mDAO == null) {
			mDAO = new MembersDAO();
		}
		return mDAO;
	}
	//CRUD
	public Member selectOne(Member member) {
		Member loginInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM members WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			rs = pstmt.executeQuery();
			if(rs.next()) {	//아이디 존재
				if(rs.getString("member_pw").equals(member.getMemberPw())) {
					// 비밀번호 일치 -> 로그인성공
					member.setMemberRole(rs.getInt("member_role"));
					loginInfo = member;
				} else {
					// 비밀번호 불일치 -> 로그인 실패
					System.out.println("비밀번호가 틀렸습니다.");
				}
			} else {	// 아이디 없음
				System.out.println("아이디가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return loginInfo;
	}
	
}
