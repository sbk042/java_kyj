package day13.practice;

import lombok.Data;

@Data
public class Subject {
	// 멤버변수
	private String title; // 과목명 : 국어, 영어, 수학
	private double total; // 과목의 총점 = 중간 + 기말 + 수행평가
	private double midTerm; // 중간고사
	private double finalTerm; // 기말고사
	private double performance; // 수행평가
	private int grade; // 학년
	private int semester; // 학기
	
	
	// 생성자
	public Subject(String title) {
		this.title = title;
		this.grade = 1; // 적어도 1학년 0학년X
		this.semester = 1;// 적어도 1학기 0학기X
	}
	// 우클릭 source를 이용해서 만듬
	public Subject(String title, int grade, int semester) {
		this.title = title;
		this.grade = grade;
		this.semester = semester;
	}
	
	// 메서드
	/** 중간고사 성적 추가/수정 : setMidTerm */
	
	/** 기말고사 성적 추가/수정 : setFianlTerm */
	
	/** 수행평가 성적 추가/수정 : setPerformance */
	
	/** 성적 추가( 전체 )/수정 */
	public void updateScore(int midTerm, int FinalTerm, int Performance) {
		this.midTerm = midTerm;
		this.finalTerm = finalTerm;
		this.performance = performance;
		total = midTerm + finalTerm + performance;
	}
	/** 성적 출력 */
	public void print() {
		System.out.println("title : " + title);
		System.out.println("grade : " + grade);
		System.out.println("semester : " + semester);
		System.out.println("mid : " + midTerm);
		System.out.println("final : " + finalTerm);
		System.out.println("perform : " + performance);
		System.out.println("total : " + total);
	}
}
