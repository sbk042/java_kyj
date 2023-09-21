package kr.kh.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.dao.BoardDAO;
import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.util.UploadFileUtils;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	// 직접 d드라이브에 있는 폴더 주소 넣기
	String uploadPath = "D:\\uploadfiles";
	
	//게시판 조회 & 검색기능
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	// 페이지네이션
	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectCountBoardList(cri);
	}
	
	//게시글 등록
	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] fileList) {
		if(board == null || board.getBo_title() == null 
						 || board.getBo_title().trim().length() == 0
						 || board.getBo_contents() == null) {
			return false;
		}
		// 작성자가 없으면 안되기 때문에 
		if (user == null ) {
			return false;
		}
		// 게시글 작성자를 로그인한 회원 아이디로 수정해주는 작업이다.
		board.setBo_me_id(user.getMe_id());
		// 게시글을 DB에 저장하라고 쓴 코드이다.
		boolean res = boardDao.insertBoard(board);
		
		if(!res) {
			return false;
		}
		//첨부파일 등록하는 작업
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		for(MultipartFile file : fileList) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				// 원래 파일명
				String fi_ori_name = file.getOriginalFilename();
				// 서버에 업로드 후 업로드된 경로와 uuid가 포함된 파일명
				String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
				// 파일 객체만들기
				FileVO fileVo = new FileVO(board.getBo_num(), fi_name, fi_ori_name);		
				boardDao.insertFile(fileVo);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public List<FileVO> getFileList(int num) {
		return boardDao.selectFileList(num);
	}
}
