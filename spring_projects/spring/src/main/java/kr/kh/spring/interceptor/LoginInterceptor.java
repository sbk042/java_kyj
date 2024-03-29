package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// 자동로그인을 체크한 경우
			if(user.isAutoLogin()) {
				// 쿠키를 생성하여 필요한 정보를 넣고, 클라이언트한테 전달해줘야 한다.
				Cookie cookie = new Cookie("loginCookie", session.getId());
				// >> 이름은 loginCookie라고 지음
				cookie.setPath("/");
				int day = 7; // 일주일을 자동로그인을 할 수 있다고 한다.
				int time = 60 * 60 * 24 * day;
				cookie.setMaxAge(time);
				//화면에 전달하기 위해 response활용
				response.addCookie(cookie);
				// 쿠키에 넣은 필요한 정보를 DB에도 추가해줘야한다.(서로 약속임)
				user.setMe_session_id(session.getId());
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}
}
