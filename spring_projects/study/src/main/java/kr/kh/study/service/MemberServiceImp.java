package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;


@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || 
		   member.getMe_id() == null || 
		   member.getMe_pw() == null ||
		   member.getMe_email() == null) {
			return false;
		}
		// 유효성 검사
		// 아이디 중복체크 전에 유효성 검사를 해야됨
		if(!checkRegexMember(member)) { // 메소드를 만드는 이유는 편하게 확인하기 위해
			return false;
		}
		
		// 아이디 중복체크
		// 아이디로 회원정보를 가져옴
		// memberDao한테 아이디를 가져오라고 시킴 중복인지 체크하기 위해
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) { // null이 아니면 있는 것이므로 중복임!
			return false;
		}
		
		// 회원가입 진행
		//memberDao.insertMember(member); //memberDao에게 회원정보를 주며 회원가입하라고 시킴
		//return true;
		// = return memberDao.insertMember(member) 이렇게 써도 같은 코드다.
		
		// 비밀번호 암호화하기
		String encPw = passwordEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		}
	

	// 요거는 유효성 검사 메소드 
	private boolean checkRegexMember(MemberVO member) {
		// 필요하면 유효성 검사 코드를 구현
		return true;
	}


	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || 
		   member.getMe_id() == null || 
		   member.getMe_pw() == null) {
			return null;
		}//아이디 주면서 회원정보 가져와달라고 한다.
		MemberVO user = memberDao.selectMember(member.getMe_id()); 
		if( user == null) {
			return null;
		}
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}

	// 자동로그인
	@Override
	public void updateMemberSession(MemberVO user) {
		// 아이디가 없으면 업데이트를 하지 못하게 막아주고
		if(user == null || user.getMe_id() == null) {
			return;
		}
		// 있으면 업데이트를 하게 다오에게 시킨다.
		memberDao.updateMemberSession(user);
		
	}


	@Override
	public MemberVO getMemberBySessoion(String me_session_id) {
		return memberDao.selectMemberBySession(me_session_id);
	}
}
