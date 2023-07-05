package day26.library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

//대출 열람(도서대출 기록을 볼 수 있는 클래스)
@Data
public class LoanBrowsing implements Serializable{

	private static final long serialVersionUID = 4272632230761810647L;
	
	//멤버변수를 추가
	private Book book; //대출도서
	private Date loanDate; //대출일
	private Date returnDate; //반납일 
	
	public LoanBrowsing(Book book2, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
	}
	//현재 날짜를 출력해주는 메서드 생성
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}
}
