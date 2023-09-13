package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.dao.CommentDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;
import kr.kh.study.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	CommentDAO commentDao;
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_me_id() == null || comment.getCo_contents() == null) {
			return false;
		}
		boolean res = commentDao.insertComment(comment);
		
		if(!res) {
			return false;
		}
		// 게시글의 댓글을 수정
		// boardDao한테 comment에서 댓글 번호를 가져다가 update해달라고 시킨다.
		boardDao.updateBoardComment(comment.getCo_bo_num());
		return true;
		
	}
	// 댓글 조회
	@Override
	public List<CommentVO> getCommentList(int bo_num, Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return commentDao.selectCommentList(bo_num, cri);
	}
	@Override
	public int getTotalCount(int bo_num) {
		return commentDao.selectCommentCount(bo_num);
	}
	// 댓글삭제
	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(comment == null || comment.getCo_num() == 0) {
			return false;
		}
		// 작성자인지 아닌지를 모르기 때문에 댓글을 가져와야한다.
		CommentVO dbComment = commentDao.selectComment(comment.getCo_num());
		// 가져온 댓글이 null이거나 댓글의 아이디가 지금 삭제하려는 user의 아이디와 같지 않으면 안됨
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id())) {
			return false;
		}
		// 그렇지 않다면 commentDao에게 댓글번호를 주며 댓글을 삭제해 달라고 요청한다.
		boolean res = commentDao.deleteComment(comment.getCo_num());
		boardDao.updateBoardComment(dbComment.getCo_bo_num());
		return res;
	}
	// 댓글 수정
	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(user == null || user.getMe_id() ==null) {
			return false;
		}
		if(comment == null || comment.getCo_num() == 0 ||
			comment.getCo_contents() == null ||
			comment.getCo_contents().trim().length() == 0) {
			return false;
		}
		// 작성자 확인
		CommentVO dbComment = commentDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id())) {
			return false;
		}
		return commentDao.updateComment(comment);
	} 
}
