package kr.kh.spring.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO { // 만드는 이유 : controller에서 받는 걸 한 번에 받기 위해서
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_session_id;
	private Date me_session_limit;
	
	private boolean autoLogin;
}
