package day27.Attendance.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
//학생클래스 (등록한 학생들을 관리하는 클래스)
public class Student implements Serializable{ 
	
	private static final long serialVersionUID = 2458588778450531848L;
	
	//1.)멤버 변수 선언
	private String name; //이름
	private String num; //학번
	
	//2.) 우클릭->source->Generate Constructor using fields
	public Student(String name, String num) {
		this.name = name;
		this.num = num;
	}
	//복사생성자
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}

	//학번으로만 객체가 같은지 판별하기 위해 만듬
	//3.) 우클릭 -> source ->Generate hashcode() equls()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	//4.) 우클릭 -> source -> Generate toString
	@Override
	public String toString() {
		return num + " " + name;
	}

	
	
}
