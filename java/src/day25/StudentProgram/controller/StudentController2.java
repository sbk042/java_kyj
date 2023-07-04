package day25.StudentProgram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.StudentProgram.vo.Student;

//program을 이용해서 만든다.
public class StudentController2  {
	/*대학생 관리 프로그램을 작성하세요.
	 * 기능 - 학생등록, 학생확인, 종료
	 * 학생 - 학번, 과, 이름
	 * */
	
	//먼저 스캐너와 변수들을 선언한다.

	public void run() {
		Scanner sc = new Scanner(System.in);
		int menu;
		List<Student> list = new ArrayList<Student>(); //student라는 ArrayList를 생성 즉 리스트를 생성
		do { //반복한다 언제까지?
			System.out.println("=========");
			//1. 메뉴 출력
			printMenu();
			//2.메뉴 선택(메뉴를 입력받음)
			menu = sc.nextInt(); //번호 받기
			//3.선택된 메뉴에 따른 기능을 실행
			runMenu(menu,sc, list); //실행
			System.out.println("=========");
			
		}while(menu != 3);//메뉴가 3이 아닐 때 까지 반복한다.
	}
	

	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Insert");
		System.out.println("2. Search");
		System.out.println("3. EXIT");
		System.out.print("select Menu : ");
	}


	public void runMenu(int menu, Scanner sc, List<Student> list) {
		switch(menu) {
		case 1 : //학생정보 입력
			insertStudent(sc, list);
		break;
	case 2 :
		//학생 전체를 확인
		print(list);
		break;
	case 3 :
		break;
	default :
		System.out.println("Wrong Menu!!!");
	}

	}
	public void insertStudent(Scanner sc, List<Student> list) {
		String num, name, major; //학번, 이름, 과 String으로 선언
		
		Student tmp;
		
		//학번(문자열, 공백이 없는)
		System.out.println("학번 : ");
		num = sc.next();
		//이름(문자열, 공백이 있는)
		System.out.println("이름 : ");
		name = sc.nextLine();
		//전공(문자열, 공백이 있는)
		System.out.println("전공 : ");
		major = sc.nextLine();
		//다 입력 받았으면
		//학생정보 리스트에 정보를 저장한다.
		//입력한 정보를 이용하여 학생 객체를 생성
		tmp = new Student(num, name, major);
		//리스트에 학생 객체를 추가한다.
		list.add(tmp);
	}

	private void print(List<Student> list) {//student리스트를 매개변수로 받고
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}
}
