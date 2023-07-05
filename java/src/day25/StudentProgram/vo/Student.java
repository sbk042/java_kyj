package day25.StudentProgram.vo;

import java.io.Serializable;

public class Student implements Serializable{ //학생을 관리하는 클래스
//한 학생을 관리하는 것

	// implements Serializable코드를 추가하면 Student 노란색줄이 있는데 커서를 갖다대면
	// 두번째 시리얼 ID클릭해서 밑에 있는 코드를 추가해야 한다.
	private static final long serialVersionUID = 8283857468842193979L;
	private String num, name, major;
	//난 Data잘 모르겠다 
	// 우클릭 -> 소스 -> getter,setter 클릭
	// 우클릭 -> 소스 -> toString 클릭
	
	public Student(String num, String name, String major) {
		this.num = num;
		this.name = name;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", major=" + major + "]";
		//이렇게 출력하고 싶지 않다 싶으면 내가 원하는데로 바꿔주면 된다.
		//return"학번 : " + num + "\n이름 : " + name + "\n전공" + major;
		// \n은 엔터 기능이다.
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	

}
