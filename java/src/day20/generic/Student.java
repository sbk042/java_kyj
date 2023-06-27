package day20.generic;

public class Student <T extends Number> {
	{
		// TODO Auto-generated constructor stub
	}
	int grade, classNum, num;
	String name;
	public T kor, math, eng; //제네릭 타입으로 지정
	
	
	public void update(int grade2, int classNum2, int number, String name2) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = number;
		this.name = name;
		
	}
}
