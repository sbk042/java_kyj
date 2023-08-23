package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.MemberVO;

public class MemberServiceImp implements MemberService{

	private MemberDAO memberDAO;
	private final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";
	
	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// true의 역할 : 쿼리(insert,update,delete)실행 후 자동 커밋(commit)되게 해줌
			SqlSession session = sf.openSession(true);
			memberDAO = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO member) {
		//매개변수 예외처리
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		//아이디 중복 확인
		//아이디가 일치하는 회원 정보를 가져옴
		MemberVO dbMember = memberDAO.selectMember(member.getMe_id());
		System.out.println(member);
		//회원 정보가 있으면 => 아이디 중복
		if(dbMember != null) {
			return false;
		}
		memberDAO.insertMember(member);
		return true;
	}

	@Override
	public boolean withdraw(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		//아이디가 일치하는 회원 정보를 가져옴
		MemberVO dbMember = memberDAO.selectMember(member.getMe_id());
		//회원 정보가 없으면 탈퇴 불가능
		if(dbMember == null) {
			return false;
		}
		//비번이 일치하지 않으면
		if(!dbMember.getMe_pw().equals(member.getMe_pw())) {
			return false;
		}
		memberDAO.deleteMember(member.getMe_id());
		return true;
	}
}
