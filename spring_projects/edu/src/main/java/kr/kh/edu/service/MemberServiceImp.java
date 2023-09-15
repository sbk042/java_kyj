package kr.kh.edu.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.edu.dao.MemberDAO;
import kr.kh.edu.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	
	@Autowired
	MemberDAO memberDao;
	@Override
	public boolean signup(MemberVO member) {
		// 넘겨진 데이터가 
		if(member == null) {
			return false;
		}
		// 아이디 체크
		// 전체 6~20자, 영문으로 시작, 영문 숫자만 가능하다.
		String regexId = "^[a-zA-Z]\\w{5,19}$";
		if(member.getMe_id() == null || !Pattern.matches(regexId, member.getMe_id())) {
			return false;
		}
		// 비번 체크
		// 전체 6~20자, 영문 숫자만 가능
		String regexPw = "\\w{6,20}";
		if(member.getMe_pw() == null || !Pattern.matches(regexPw, member.getMe_pw())) {
			return false;
		}
		// 이메일 체크는 생략하겠음
		return memberDao.insertMember(member);
	}
}
