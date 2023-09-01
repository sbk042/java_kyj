package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		// 현재 페이지에 맞는 게시글을 가져와야함
		List<BoardVO> list = boardService.getBoardList(cri);
		//int totalCount = boardService.getTotalCount(cri);
		//PageMaker pm = new PageMaker(3, cri, totalCount);
				
		//model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user"); // insert.jsp에서 input name이 files라서 이름을 같게 써야 한다.
		Message msg; // 먼저 객체를 만들고
		if(boardService.insertBoard(board, user, files)) { // 게시글을 등록할 때 같이 넘겨줘야하기 떄문에 files를 추가해준다.
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else { // 실패한다면 그 화면 그대로 있고 안내문구만 나간다.
			msg = new Message("/board/insert", "게시글을 등록하지 못했습니다.");
		}
		System.out.println(board);
		model.addAttribute("msg",msg);
		return "message";
	}
}
