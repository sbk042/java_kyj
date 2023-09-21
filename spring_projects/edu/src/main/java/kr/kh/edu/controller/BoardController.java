package kr.kh.edu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.pagination.PageMaker;
import kr.kh.edu.service.BoardService;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;


@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/list")
	public String list(Model model, Criteria cri) {
		// 현재 페이지 정보에 맞는 게시글을 가져오라고 서비스에게 시킴
		List<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색어, 차입)에 맞는 전체 게시글 수를 가져옴
		int totalCount = boardService.getTotalCount(cri);
		// 페이지네이션 페이지수
		final int DISPLAY_PAGE_NUM = 3;
		
		PageMaker pm = new PageMaker(DISPLAY_PAGE_NUM, cri, totalCount);
		
		// 화면에 데이터를 전송하기 위해서 model에 list를 담아서 보낸다.
		model.addAttribute("list", list);
		model.addAttribute("title" , "게시글 조회");
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	// 게시글 등록(화면과 연결)
	@GetMapping("/board/insert")
	public String insert() {
		return "/board/insert";
	}
	
	// 게시글 화면에 전송하기
	@PostMapping("/board/insert") // 로그인한 회원 정보를 가져오기 위해서 session을 가져와야됨
	public String insertPost(Model model, BoardVO board, 
							HttpSession session, MultipartFile[] fileList) {
		// 지금 로그인한 user의 정보를 가져온다.
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 게시글과 회원정보를 주면서 서비스한테 회원 추가를 하라고 시킨다.
		boolean res = boardService.insertBoard(board, user, fileList);
		if(res) {
			model.addAttribute("msg", "게시글 등록 성공");
			model.addAttribute("url", "board/list");
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			model.addAttribute("url", "board/list");
		}
		return "/main/message";
	}
	
	// 게시글 상세 조회하기
	@GetMapping("/board/detail/{bo_num}")
	public String detail(Model model, @PathVariable("bo_num")int num) {
		BoardVO board = boardService.getBoard(num);
		List<FileVO> fileList = boardService.getFileList(num);
		
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		return "/board/detail";
	}
}
