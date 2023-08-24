package kr.kh.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;


public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImp(); // 여기 멤버추가
	
    public BoardInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 미리 만들어 놓은 boardinsert.jsp와 연결해주기
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. 화면에서 보낸 제목과 작성자를 가져오는 작업
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		BoardVO board = new BoardVO(title,id); //하나로 묶어 보내기 위해 객체를 만들고 멤버추가를 한다.
		boolean ok = false;
		
		if(boardService.insertBoard(board)){//boardservice한테 일을 시킴
			ok = true;
		}
		request.setAttribute("ok", ok);
		doGet(request, response);
	}
		

}
