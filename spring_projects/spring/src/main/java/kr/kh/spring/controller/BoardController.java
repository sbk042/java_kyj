package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		//현재 페이지에 맞는 게시글을 가져와야함
		List<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user, files)) {
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/insert", "게시글을 등록하지 못했습니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	@GetMapping("/detail")
	public String detail(Model model, Integer bo_num , Criteria cri) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		// 
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
		return "/board/detail";
	}
	// 수정 mapping작성 
	@GetMapping("/update")
	public String update(Model model, Integer bo_num, HttpSession session) { // 기존 게시글 번호를 가져온다. (Integer bo_num)
		// 게시글 정보 가져오기
		BoardVO board = boardService.getBoard(bo_num); // 첨부파일까지 다 포함된 정보를 가져온다.
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 로그인을 안 했거나 게시글이 없거나 작성자가 아닌 경우는 안내문구를 보여주고 다시 게시글리스트로 돌아가는 코드이다.
		if(user == null || board == null || !user.getMe_id().equals(board.getBo_me_id())) {
			Message msg = new Message("/board/list", "잘못된 접근입니다.");
			model.addAttribute("msg", msg);
			return "message";
		}
		// 가져온 뒤 화면에 전달만 하면 끝!
		model.addAttribute("board",board);
		return "/board/update";
	}	
	@PostMapping("/update") 
	public String updatePost(Model model, 
							BoardVO board, //수정된 게시글 받아오기 BoardVO board
							MultipartFile[] files, // 새로 추가된 첨부파일들
							Integer[] delFiles,  // 삭제된 첨부파일들
							HttpSession session) { //
		Message msg;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, delFiles, user)) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "게시글을 수정했습니다.");
		}else {
			msg = new Message("/board/update?bo_num="+board.getBo_num(), "게시글을 수정하지 못했습니다.");
		}
		model.addAttribute("msg",msg);
		return "message";
	}
	@GetMapping("/delete")
	public String delete(Model model, HttpSession session, Integer bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.deleteBoard(bo_num, user)) { // 게시글 정보와 사용자 정보를 주며 boardService한테 삭제하라고 시킴
			msg = new Message("/board/list", "게시글을 삭제했습니다.");
		}else {
			msg = new Message("/board/list", "잘못된 접근입니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@ResponseBody
	@PostMapping("/like")
	public Map<String, Object> ajaxTest(@RequestBody LikeVO likeVo){
		Map<String,Object> map = new HashMap<String, Object>();
		// 추천 : 1, 비추천 : -1, 취소 : 0
		// 추천 정보를 주면서 서비스한테 
		int res = boardService.like(likeVo);
		map.put("res", res);
		return map;
	}
}