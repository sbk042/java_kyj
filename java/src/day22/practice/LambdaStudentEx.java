package day22.practice;

import java.util.Scanner;

import day22.practice.controller.StudentManager;
import lombok.AllArgsConstructor;
import lombok.Data;

public class LambdaStudentEx {


	public static void main(String[] args) {
		/* 학생 정보를 출력하는 기능을 구현하세요.
		 * 1. 학생 전체 출력
		 * 2. 학생 학년 출력
		 * 3. 학생 검색 출력
		 * 4. 종료
		 * */
		StudentManager sm = new StudentManager();
		sm.run();
		
		
		Scanner sc = new Scanner(System.in);
		int menu;
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//메뉴 기능 생성
			runMenu(menu);
			
		}while(menu != 4);

	}
	private static void printMenu() {
		System.out.println("1. 학생 전체 출력");
		System.out.println("2. 학생 학년 출력");
		System.out.println("3. 학생 검색 출력");
		System.out.println("4. 프로그램 종료");
		System.out.print("Select Menu : ");	
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			printStudent();
			break;
		case 2 :
			printGrade();
			break;
		case 3 :
			printFind();
			break;
		case 4 : break;
		default : 
			System.out.println("Wrong menu!");
		}
	}
	private static void printStudent() {
		
		
	}
	private static void printGrade() {
		
		
	}
	private static void printFind() {
		
		
	}


}
//학생 정보
@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
}