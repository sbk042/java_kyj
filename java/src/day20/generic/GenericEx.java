package day20.generic;

import java.util.Scanner;

public class GenericEx {

	public static void main(String[] args) {
		Student<Integer> std = new Student<Integer>();
		std.kor = 10; //integer라는 정수로 받기로 함, 실수를 넣으면 안됨 X 에러발생 ex)10.0
		Student <Double> std2 = new Student<Double>();
		std2.kor = 10.0; //double로 받기로 했기 때문에 실수를 넣음 (위에 있는 식)
		/*
		Student<Scanner> std3 = new Student<>();
		std3.kor =10;
		*/ //T extends Number 이므로 number만 자식클래스로 들이기 때문에
		//Scanner는 들어갈 수 없다.
		
		print(std2);
		GenericEx.<Double>print(std2); //만약 이름을 붙인다면 이렇게 작성하고 호출
		GenericEx.print(std2); //std2가 Double로 되어 있어서 print의 T를 Double이라고 주장할 수 있어서
	}
	
	// 학생 정보를 출력하는 메서드
	public static <T extends Number> void print(Student<T> std) {
		System.out.println(std.grade);
		System.out.println(std.classNum);
		System.out.println(std.num);
		System.out.println(std.name);
		System.out.println(std.kor);
	}
}
