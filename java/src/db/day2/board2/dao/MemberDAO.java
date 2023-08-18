package db.day2.board2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day2.board2.vo.MemberVo;

public interface MemberDAO {

	MemberVo getMember(String id);

	void insertMember(@Param("id") String id, @Param("pw")String pw);

	void deleteMember(String id);

	ArrayList<MemberVo> selectMemberList();

}
