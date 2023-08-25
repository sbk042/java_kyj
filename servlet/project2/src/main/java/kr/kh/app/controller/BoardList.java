package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;


public class BoardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();

    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 페이지 정보인 Criteria
		int page = 1;
		int perPageNum = 3; //한페이지에 게시글을 3개씩
		try {
			page = Integer.parseInt(request.getParameter("page"));
			page = page < 1 ? 1 : page;
		}catch(Exception e) {}
		Criteria cri = new Criteria(page, perPageNum);
		// 전체 게시글 수
		int totalCount = boardService.getTotalCount();
		// 페이지네이션에서 최대 페이지 개수
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		
		List<BoardVO> list = boardService.getBoardList(cri); //가져와주세요~
		request.setAttribute("list", list); 
		request.setAttribute("pm", pm);
		// 여기다가 작성할 수 있지만 그러면 코드가 굉장히 길어지므로 jsp를 만들어서 연결해 주는게 깔끔하게 만들 수 있음.
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	} 	// '/'는 절대 경로라는 뜻 다른주소가 올 수 없다.


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
