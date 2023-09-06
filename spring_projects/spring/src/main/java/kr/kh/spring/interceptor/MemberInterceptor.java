package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에 회원 정보가 없으면 메인 페이지로 이동
		// 세션이 없으면 request로 얻어올 수 있다.
		Object user = request.getSession().getAttribute("user");
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user == null) {
			// "/" 메인 페이지로 이동 => /member/login 로그인화면으로 이동 바꿈
			response.sendRedirect(request.getContextPath()+"/member/login");
			// 기존에 가려던 URL은 방문하지 않고 메인으로 이동
			return false;
		}
		// 로그인을 했으면 기존에 가려던 URL을 방문해서 작업한다.
		return true;
	}
}
