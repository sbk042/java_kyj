package kr.kh.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired //( private BoardService boardService = new BoardServiceImp(); 를 대신해서 어노테이션을 넣은 것)
	private BoardService boardService;
	
	// 1. 게시글 조회하기
	@GetMapping("/board/list")
	public String boardList(Model model) {
		//Model model = new model;
		// 이렇게 코드 작성을 할 수 있지만 매개변수로 넘겨주는게 더 편하다.
		// 서비스에게 게시글 리스트를 가져오라고 시킨다.
		List<BoardVO> list = boardService.getBoardList();
		// 가져온 리스트를 화면에 전송해준다.
		model.addAttribute("list",list);
		return "/board/list";
	} 
	// 2. 게시글 상세 조회하기
		@GetMapping("/board/detail") // integer는 null을 저장할 수 있기 때문에 Int보다는 Integer로 
		public String boardDetail(Model model, Integer bo_num) { // 화면에 전달하기 위해서는 model이 필요하다.
			// 서비스에게 게시글 번호를 주면서 상세정보를 가져오라고 요청한다.
			BoardVO board = boardService.getBoard(bo_num);
			// 가져온 게시글을 화면에 전송해준다.
			model.addAttribute("board",board);
			return "/board/detail";
		}
	}
