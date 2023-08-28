package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;

@Controller
public class MemberController {

	@Autowired // 어노테이션을 이용하여 memberService의 객체를 자동으로 만든다.
	private MemberService memberService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		int count = memberService.count();
		System.out.println(count);
		return "member/signup";
	}
}
