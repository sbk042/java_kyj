package day26.library.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
//미리 Serializable import해주기

@Data //데이터 어노테이션 추가
public class Book implements Serializable{

	private static final long serialVersionUID = 8247450705251578088L;
	//책을 관리하는 클래스
	
	//1.) 초기화할 멤버변수 등록해주기
	private String num,title,author,isbn;
	//대출여부를 관리하는 변수를 추가한다. true - 대출 불가능/ false - 대출 가능
	private boolean loan; 
	
	
	@Override //우클릭->source->to String이용하여 어떻게 출력 될지 적어준다.
	public String toString() {
		return "도서번호 : " + num + "\n" +
				"도서제목 : " + title + "\n" +
				"도서저자 : " + author + "\n"+
				"ISBN : " + isbn;
	}
	//우클릭->source->feild 이용
	public Book(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	public void loanBook() {
		this.loan = true; // setLoan(true); 왼쪽에 있는 것이 이것과 똑같음
	}
	public void returnBook() {
		this.loan = false; //setLoan(false);  이것과 똑같음
	}
	//우클릭->source->hashcode 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(num, other.num);
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
}












