package day9.classEx;

import java.util.Scanner;

public class StudentScoreManager {

	public static void main(String[] args) {
		// 클래스는 멤버변수, 메서드, 생성자로 구성
		// 멤버변수 : 속성
		// 메서드 : 기능
	
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		//korScore를 인스턴스, 객체 라고 한다.
		//Score1 korscore = new Score1(1,2,"korean Language")
		Score1 korScore = new Score1();
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		Score1 engScore = new Score1(1,2,"English");
		System.out.println(engScore.title);
	}

}
// 성적 클래스
class Score1{
	public Score1(String title, int grade, int semester, double total, double midExam, double finalExam,
			double performance) {
		
	}
	String title; // 과목명				
	int grade; // 학년
	int semester; // 학기
	double total; // 총점수
	double midExam; // 중간고사
	double finalExam; // 기말고사
	double performance; //수행평가
	//Score1 클래스의 기본 생성자
	public Score1() {
		/* title의 기본값은? null로 초기화가 되어 있음 (string이어서)
		 * grade의 기본값은? 0 (int 여서)
		 * total의 기본값은? 0.0 (double 이여서)
		 * */
		title = "";
		grade = 1; //1학년부터 시작임
		semester = 1; //1학기부터 시작임
	}
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getMidExam() {
		return midExam;
	}
	public void setMidExam(double midExam) {
		this.midExam = midExam;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	this.title = title;
	this.grade = grade;
	this.semester = semester;
	this.total = total;
	this.midExam = midExam;
	this.finalExam = finalExam;
	this.performance = performance;
	
}
// 학생 클래스
class student1{
	String name; //이름
	String residentNumber; //주민번호 
	int grade; // 학년
	int classNum; // 반
	int number; // 번호
	int admisssionYear; // 입학년도
	Score1 korScore, engScore, mathScore; // 국어, 영어, 수학 성적
			
}