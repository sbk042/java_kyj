package day27.Attendance.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Attendance implements Serializable{ //출석 클래스(학생 한명이 특정날에 출석했는지를 알려주는 클래스)

	private static final long serialVersionUID = 1762437507283465260L;
	
	private Date date; //출석날짜
	private Student student; //학생정보
	private boolean attendance; //출석 여부

	//1.) 우클릭 -> source -> Generate contructor using fields
	// 출석일, 학생, 출석여부를 이용한 생성자 만듬 (이 멤버들을 초기화 하는 역할을 해줌)
	public Attendance(Date date, Student student, char state ) {
		super();
		this.date = date;
		this.student = student;
		this.attendance = state == 'O'?true:false;
	}
	//2.) 우클릭 ->source -> Generate toString
	@Override
	public String toString() {
		return student.toString() + " : " + (attendance?"O" : "X");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(date, other.date) && Objects.equals(student, other.student);
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, student);
	}
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
}
