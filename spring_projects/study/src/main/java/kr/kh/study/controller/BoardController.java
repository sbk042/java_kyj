package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

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
			// 3. 게시글 조회수 증가
			// 서비스에게 게시글 번호를 주면서 조회수를 1증가하라고 요청한다.
			// 언제? =>게시글 가져오기 전에 그래서 조회하기 전 코드를 입력해준다.
			boardService.updateViews(bo_num);
	// ========================================================================
			// 서비스에게 게시글 번호를 주면서 상세정보를 가져오라고 요청한다.
			BoardVO board = boardService.getBoard(bo_num);
			// 가져온 게시글을 화면에 전송해준다.
			model.addAttribute("board",board);
			return "/board/detail";
		}
	// 4. 게시글 등록하기
		@GetMapping("/board/insert")
		public String BoardInsert() {
			return "/board/insert";
		}
		@PostMapping("/board/insert")
		public String boardInsertPost(Model model, BoardVO board, HttpSession session) {
			// 제목과 내용이 잘 넘어오는지 확인하구
			//System.out.println(board);
			
			MemberVO user = (MemberVO) session.getAttribute("user");
			
			// 서비스에게 게시글 정보와 로그인한 회원 정보를 주면서 게시글을 등록하고 시킨다.
			boolean res = boardService.insertBoard(board, user);
			if(res) {
				model.addAttribute("msg", "게시글을 등록했습니다.");
				model.addAttribute("url", "/board/list");
			}else {
				model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
				model.addAttribute("url", "/board/insert");
			}
			
			return "/util/message";
		}
	}
