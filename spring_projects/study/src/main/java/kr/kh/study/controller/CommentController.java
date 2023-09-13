package kr.kh.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.pagination.PageMaker;
import kr.kh.study.service.CommentService;
import kr.kh.study.vo.CommentVO;
import kr.kh.study.vo.MemberVO;

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
	// 댓글 조회하는 메서드 추가
	@PostMapping("/comment/list/{bo_num}") 
	public Map<String,Object> list(@RequestBody Criteria cri ,@PathVariable("bo_num")int bo_num){ // 매개변수로 현재 페이지를 넘겨준다.
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 현재 페이지를 3개로 나눈다. 123,456,789
		cri.setPerPageNum(3);
		// 댓글리스트를 가져와야됨
		List<CommentVO> list = commentService.getCommentList(bo_num, cri);
		// 이 게시글의 댓글 수를 알려주세요 번호를 넘기면서
		int totalCount = commentService.getTotalCount(bo_num);
		// 한번에 3페이지 까지만 보여줌 => 3
		PageMaker pm = new PageMaker(3, cri, bo_num);
		// 가져왔으면 보내줘야함.
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	//댓글 삭제하는 메서드 추가
	@PostMapping("/comment/delete")// @RequestBody CommentVO comment => 화면에서 보내 준 댓글 정보를 갖고온다.
	public Map<String,Object> delete(@RequestBody CommentVO comment, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = commentService.deleteComment(comment,user);
		map.put("res", res);
		return map;
	}
	// 댓글 수정!
	@PostMapping("/comment/update")// @RequestBody CommentVO comment => 화면에서 보내 준 댓글 정보를 갖고온다.
	public Map<String,Object> update(@RequestBody CommentVO comment, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = commentService.updateComment(comment, user);
		map.put("res", res);
		return map;
	}
}
