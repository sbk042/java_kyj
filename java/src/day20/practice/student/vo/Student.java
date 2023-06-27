package day20.practice.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student{

	int grade, classNum, num;
	private String name;
		
public void update(int grade2, int classNum2, int number, String name2) {
	this.grade = grade;
	this.classNum = classNum;
	this.num = number;
	this.name = name;
}


