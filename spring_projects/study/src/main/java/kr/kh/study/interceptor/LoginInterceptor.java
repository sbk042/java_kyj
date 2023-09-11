package kr.kh.study.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");

		if(user != null) {
			request.getSession().setAttribute("user", user);
			// 자동로그인 기능구현
			if(user.isAutoLogin()) {
				// 쿠키를 생성한다.
				// 쿠키는 이름과 value가 필요하다.
				// 이름은 지어주기 나름이므로 lc(loginCookie)라고 지정해준다.
				String value = request.getSession().getId();
				Cookie cookie = new Cookie("lc", value );
				cookie.setPath("/");				
				//쿠키 유지 시간은 초로 넣어줘야한다.
				int day = 7;
				int time = day * 24 * 60 * 60; //하루를 초로 변환한 값에 day를 곱함
				cookie.setMaxAge(time);
				// client한테 cookie를 보내줘야하기 때문에 response를 이용한다. 
				response.addCookie(cookie);
				
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_id(value);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}
	
}
