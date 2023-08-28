package kr.kh.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		// ȭ�鿡 �����͸� �����ϴ� ��� model�� ��Ƽ� �����ؾ� �Ѵ�.
		// model.addAllAttributes("ȭ�鿡�� ����� �̸�", ������ ��);
		model.addAttribute("name","abc"); //ȭ�鿡 ���� ���ϴ� �����͸� ����
		return "home";
	}
	@RequestMapping(value = "/test1")
	public String test1(Model model, String id, Integer age) {
		System.out.println("���̵�: " + id);
		System.out.println("���� : " + age);
		return "test1";
	}
}
