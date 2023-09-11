package kr.kh.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.study.service.CommentService;
import kr.kh.study.vo.CommentVO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	// 댓글등록 메서드 추가
	@PostMapping("/comment/insert") // @RequestBody CommentVO comment => 화면에서 보내 준 댓글 정보를 갖고온다.
	public Map<String,Object> insert(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean res = commentService.insertComment(comment);
		map.put("res", res);
		return map;
	}
}
