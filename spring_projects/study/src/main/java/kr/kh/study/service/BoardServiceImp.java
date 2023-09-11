package kr.kh.study.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.util.UploadFileUtils;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;
import kr.kh.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";
	
	// 1. 게시글 조회하기 
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		// 매개변수체크(생략)
		if(cri == null) {
			cri = new Criteria();
		}
		// 다오에게 게시글 리스트를 가져오라고 시키고
		List<BoardVO> list = boardDao.selectBoardList(cri);
		// 가져오면 list로 반환을 해준다.
		return list;
	}
	// 2. 게시글 상세 조회 
	@Override
	public BoardVO getBoard(Integer bo_num) {
		// 매개변수체크
		// null 체크만 해주면 된다.
		if(bo_num == null) {
			return null;
		}
		// DAO에게 게시글 번호를 주면서 게시글을 가져오라고 시킨다.
		BoardVO board = boardDao.selectBoard(bo_num);
		//가져오면 반환
		return board;
	}
	// 3. 게시글 상세 조회 후 조회수 증가
	@Override
	public void updateViews(Integer bo_num) {
		// 매개변수체크
		if(bo_num == null) {
			return ;
		}
		// 다오에게 게시글 번호를 주면서 조회수를 1증가시키라고 요청한다.
		boardDao.updateBoardViews(bo_num);
	}
	// 4. 게시글 등록하기
	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		// 매개변수체크
		if(user == null || user.getMe_id() == null) { 
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		//로그인한 회원 아이디로 작성자를 수정해준다.
		board.setBo_me_id(user.getMe_id());
		// DAO에게 게시글 정보를 주면서 게시글을 추가하라고 시키고 추가 여부를 알려달라고 요청한다.
		boolean res = boardDao.insertBoard(board);
		// 첨부파일
		if(!res) {
			return false;
		}
		//첨부파일 추가 
		uploadFiles(files, board.getBo_num());
		return true;
	}
	// 7. 첨부파일 추가하기
	private void uploadFiles(MultipartFile[] files, int bo_num) {
		if(files == null || files.length == 0) {
			return;
		}
		if(bo_num <= 0) {
			return;
		}
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				String fi_ori_name = file.getOriginalFilename();
				String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
				FileVO fileVo = new FileVO(fi_name, fi_ori_name, bo_num);
				boardDao.insertFile(fileVo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// 5. 게시글 수정하기
	@Override
	public boolean update(BoardVO board, MemberVO user, MultipartFile[] files, int[] delNums) {
		// 매개변수체크
		if(user == null || user.getMe_id() == null) { 
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//추가된 첨부파일 업로드 및 DB 추가
		uploadFiles(files, board.getBo_num());
		//삭제된 첨부파일 삭제 및 DB 제거
		deleteFiles(delNums);
		boolean res = boardDao.updateBoard(board);
		return res;
	}
	
	// 8. 첨부파일 삭제
	private void deleteFiles(int[] delNums) {
		if(delNums == null || delNums.length == 0) {
			return ;
		}
		List<FileVO> fileList = new ArrayList<FileVO>();
		for(int fi_num : delNums) {
			FileVO fileVo = boardDao.selectFile(fi_num);
			fileList.add(fileVo);
		}
		deleteFiles(fileList);
	}
	
	// 6. 게시글 삭제하기
	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		// 매개변수체크
		if(user == null || user.getMe_id() == null) { 
			return false;
		}
		if(bo_num == null) {
			return false;
		}
		BoardVO board = boardDao.selectBoard(bo_num);
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		return boardDao.deleteBoard(bo_num);
	}
	
	private void deleteFiles(List<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0) {
			return;
		}
		for(FileVO file : fileList) {
			if(file == null) {
				continue;
			}
			UploadFileUtils.deleteFile(uploadPath, file.getFi_name());
			boardDao.deleteFile(file.getFi_num());
		}
		
	}
	@Override
	public List<FileVO> getFileList(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectFileList(bo_num);
	}
	@Override
	public int getBoardTotalCount() {
		return boardDao.selectBoardTotalCount();
	}


}
