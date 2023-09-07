package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.CommentVO;

@Service
public class CommentServiceImp implements CommentService{

	@Autowired
	CommentDAO commentDao;
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_contents() == null || comment.getCo_me_id() == null) {
			return false;
		}
		boolean res = commentDao.insertComment(comment);
		if(!res) {
			return false;
		}
		boardDao.updateBoardComment(comment.getCo_bo_num());
		return true;
	}

	@Override
	public List<CommentVO> getCommentList(Criteria cri, int bo_num) {
		if(cri == null) {
			cri = new Criteria(); //기본 생성자 만들기
		}
		return commentDao.selectCommentList(cri, bo_num);
	}

	@Override
	public int getTotalCount(int bo_num) {
		// dao한테 바로 일 시켜버리기
		return commentDao.selectCommentCount(bo_num);
	}

	@Override
	public boolean deleteComment(CommentVO comment) {
		// 처음은 매개변수 체크~
		if(comment == null || comment.getCo_me_id() == null) {
			return false;
		}
		boolean res = commentDao.deleteComment(comment);
		if(!res){
			return false;
		}
		boardDao.updateBoardComment(comment.getCo_bo_num());
		return true;
	}

	@Override
	public boolean updateComment(CommentVO comment) {
		if(comment == null || comment.getCo_contents() == null || comment.getCo_me_id() == null) {
			return false;
		}
		return commentDao.updateComment(comment);
	}
}
