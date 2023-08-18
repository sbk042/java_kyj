package db.day2.board.service;

import java.sql.Connection;

import db.day2.board.dao.MemberDAO;
import db.day2.board.dao.MemberMapper;
import db.day2.board.vo.MemberVo;

public class MemberServiceImp implements MemberService {

	private Connection con;
	private MemberDAO memberDao;
	
	public MemberServiceImp(Connection con) {
		this.con = con;
		memberDao = new MemberMapper(con);
	}

	@Override
	public boolean signup(String id, String pw) {
		
		// 아이디가 id인 회원 정보를 가져옴
		MemberVo member = memberDao.getMember(id);
		
		// 회원의수가 0이 아니면 등록을 안하고, 
		if(member != null) {
			return false;
		}
		// 0이면 회원을 등록
		memberDao.insertMember(id, pw);
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		
		MemberVo member = memberDao.getMember(id); // 아이디 주고 회원정보 가져오기
		
		if(member != null && member.getMe_pw().equals(pw)) {
			memberDao.deleteMember(id);
			return true;
		}
		return false;
	}

}
