package kr.kh.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.edu.service.MemberService;
import kr.kh.edu.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/member/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	// 회원가입 정보 보내기
	@PostMapping("/member/signup")
	public String signupPost(MemberVO member, Model model) {
		
		//서비스에게 회원가입을 시켜야한다. => 회원정보를 주면서 => return값으로 가입여부를 알려달라고 한다.
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원가입 성공!");
			model.addAttribute("url", "");
		}else {
			model.addAttribute("msg", "회원가입 실패!");
			model.addAttribute("url", "member/signup");
		}
		return "/main/message";
	}

}
