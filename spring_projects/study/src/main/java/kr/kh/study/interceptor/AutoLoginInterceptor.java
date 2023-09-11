package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberService memberService;
	
	// preHandle을 이용해야한다. controller로 가기전 체크
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 이미 로그인되어 있으면 건너뛴다.
		HttpSession session = request.getSession();
		// 부모클래스 객체를 (Object)를 자식 클래스(MemberVO) 객체로 형변환하는 것
		MemberVO user = (MemberVO)session.getAttribute("user");
		// user가 이미 로그인 되어 있으면 건너뜀
		if(user != null) {
			return true;
		}
		// 로그인 되어 있지 않으면 쿠키 확인
		// request요청에 있는 lc라는 쿠키를 가져오고
		Cookie cookie = WebUtils.getCookie(request, "lc");
		// 만약 쿠키가 없다면 건너뜀(자동로그인 X)
		if(cookie == null) {
			return true;
		}
		// 쿠키가 있다면 가져온다.
		// memberService => 위로 올라가 @Autowired해주기
		user = memberService.getMemberBySessoion(cookie.getValue());
		if(user != null) {
			session.setAttribute("user", user);
		}
		return true;
	}
}
