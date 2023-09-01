package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user,  MultipartFile[] files) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title()==null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		//첨부파일 업로드
		
		return true;
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}
}