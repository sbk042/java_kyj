package day26.library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

//대출 열람(도서대출 기록을 볼 수 있는 클래스)
@Data
public class LoanBrowsing implements Serializable{

	private static final long serialVersionUID = 4272632230761810647L;
	
	//멤버변수를 추가
	private Book book; //대출도서
	private Date loanDate; //대출일
	private Date returnDate; //반납일 
	private Date estimatedDate; //반납 예정일
	
	public LoanBrowsing(Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
		//대출 기한을 이용하여 반납 예정일을 추가
		calculateReturnDate(loanPeriod);
	}
	
	private void calculateReturnDate(int loanPeriod) {
		if(loanDate == null) {
			return;
		}
		Long loanDateMs = loanDate.getTime(); //대출일을 밀리초로 환산해준다.
		Long periodMs = loanPeriod * 24 * 60 * 60 * 1000L;
		/* new Date() : 현재 시간을 Date객체로 생성
		 * new Date(Long a) : 1970년 1월 1일 0시를 기준으로 a밀리초만큼 흐른 날짜
		 * */
		estimatedDate = new Date(loanDateMs + periodMs);
		
	}
	
	//현재 날짜를 출력해주는 메서드 생성
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}
	//반납한 날짜를 출력해주는 메서듣 생성
	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(returnDate);
	}
	
	public String getEstimatedDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(estimatedDate);
	}
	
	//이퀄스 오버라이딩 우클릭->source->hashcode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanBrowsing other = (LoanBrowsing) obj;
		return Objects.equals(book, other.book);
	}
	@Override
	public int hashCode() {
		return Objects.hash(book);
	}
	
}
