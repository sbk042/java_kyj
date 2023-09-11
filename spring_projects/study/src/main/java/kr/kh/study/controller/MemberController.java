package kr.kh.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/signup")
	public String memberSignup() {
		return "member/signup";
	}
	//@RequestMapping(value="/member/signup", method+RequestMethod.POST)
	// 위 requestmapping과 아래 postmapping은 같은 코드이다 밑 코드가 훨씬 간단하므로 밑코드를 사용
	@PostMapping("/member/signup")
	public String memberSignupPost(Model model, MemberVO member) {
		String msg = "테스트입니다.";
		String url = "/";
		
		if(memberService.signup(member)) {
			msg = "회원가입 성공!";
			url = "/";
		}else {
			msg ="회원가입 실패!";
			url ="/member.signup";
		}
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		return "util/message"; // util message를 찾아라.
	}
	@GetMapping("/member/login")
	public String memberLogin() {
		return "member/login";
	}
	// ==========================================================================
	// 여기서부터는 로그인 구현
	@PostMapping("/member/login")
	public String memberLoginPost(Model model,MemberVO member) {
		String msg, url;
		//membervo에게 로그인 정보를 불러온다.
		MemberVO user = memberService.login(member);
		
		if(user != null) {
			msg = "로그인 성공!";
			url = "/";
			// 로그인을 성공했으면 ( 자동로그인 설정 )
			user.setAutoLogin(member.isAutoLogin());
			
		}else {
			msg ="로그인 실패!";
			url ="/member/login";
		}
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		model.addAttribute("user",user);
		return "util/message";
	}
	// 로그아웃 구현
	@GetMapping("/member/logout")
	public String memberLogout(Model model, HttpSession session) {
		String msg="로그아웃 성공!", url="/";
		
		session.removeAttribute("user");

		model.addAttribute("url",url);
		model.addAttribute("msg",msg);

		
		return "/util/message";
	}
}


