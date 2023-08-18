package db.day2.board2.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day2.board2.dao.MemberDAO;
import db.day2.board2.vo.MemberVo;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	private InputStream inputStream;
	private SqlSession session;
	
	public MemberServiceImp() {
		String resource = "db/day2/board2/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			memberDao = session.getMapper(MemberDAO.class);
		}catch (IOException e) {
			e.printStackTrace();
		}
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
		session.commit();
		// 회원 목록을 조회하는 쿼리(원래는 필요 없는 기능인데 mybatis 장점을 설명하려고 추가)
		ArrayList<MemberVo> list = memberDao.selectMemberList();
		for(MemberVo tmp : list) {
			System.out.println(tmp);
		}
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		
		MemberVo member = memberDao.getMember(id); // 아이디 주고 회원정보 가져오기
		
		if(member != null && member.getMe_pw().equals(pw)) {
			memberDao.deleteMember(id);
			session.commit();
			return true;
		}
		return false;
	}

}
