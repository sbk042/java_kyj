package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day20.practice.student.vo.Student;
/* 학생 정보를 출력하는 기능을 구현하세요.
 * 1. 학생 전체 출력
 * 2. 학생 학년 출력
 * 3. 학생 검색 출력
 * 4. 종료
 * <원래 했던 식으로>*/
public class StudentManager implements Program{
	
	private List<Student> list = Arrays.asList(//리스트를 만들어서 리턴해주는 aslist
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
		);
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;
	
	@Override
	public void printMenu() {
		System.out.println("1. All");
		System.out.println("2. Grade");
		System.out.println("3. Search");
		System.out.println("4. EXIT");
		System.out.print("Select Menu : ");	
	}

	@Override
	public void run() {
		
		int menu;
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//메뉴 기능 생성
			runMenu(menu);
			
		}while(menu != EXIT); //프로그램 종료일 때 까지 반복		
	}

	@Override
	public void runMenu(int menu) {
		int grade =1 , classNum=1 , num=1;
		switch(menu) {
		case 1:
			printAll();
			break;
		case 2 :
			//검색할 학년 입력을 받아야한다
			System.out.println("grade : ");
			grade = sc.nextInt();
			printGrade(grade);
			break;
		case 3 :
			//검색할 학년, 반, 번호를 입력
			System.out.println("grade : ");
			grade = sc.nextInt();
			System.out.println("class : ");
			classNum = sc.nextInt();
			System.out.println("number : ");
			num = sc.nextInt();
			printSearch(grade, classNum, num);
			break;
		case 4 : break;
		default : 
			System.out.println("Wrong menu!");
		}
	}
	private void printSearch(int grade, int classNum, int num) {
		for(Student tmp : list) { 
			if(tmp.equals(new Student(grade, classNum, num, ""))) {
				System.out.println(tmp);
			}
		}
	}

	private void printGrade(int grade) {
		for(Student tmp : list) { 
			if(tmp.getGrade() == grade) {
			System.out.println(tmp);
			}
		}
	}

	private void printAll() {
		for(Student tmp : list) { //ArrayList에 학생 명단이 있음
			System.out.println(tmp);
		}
		
	}	
}


