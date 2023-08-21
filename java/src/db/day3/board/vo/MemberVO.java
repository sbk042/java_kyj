package db.day3.board.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private int me_board_count;
	
	// 생성자가 추가 될 수 있다. 왜냐 => 객체를 편하게 만들기 위해서
	public MemberVO(String id, String pw) {
		this.me_id = id;
		this.me_pw = pw;
	}
	// 다름 setter와 getter : 날짜 관련했음
}
