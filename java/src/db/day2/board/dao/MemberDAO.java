package db.day2.board.dao;

import db.day2.board.vo.MemberVo;

public interface MemberDAO {

	MemberVo getMember(String id);

	void insertMember(String id, String pw);

	void deleteMember(String id);

}
