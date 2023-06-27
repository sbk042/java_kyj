package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20.practice.student.vo.Student;

public class StudentController implements Program{
	/*Student 클래스를 이용하여 학생을 등록하고 삭제하는 기능을 프로그램으로 작성하세요.
	*
	* 1.학생 추가
	* 2.학생 수정
	* 3.학생 삭제
	* 4.프로그램 종료
	* 
	* 메뉴 선택 : 
	*/
	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in); // 밖에 private으로 스캐너 생성
	private int grade, classNum, num;
	private String name;
	
	private ArrayList<Student> list = new ArrayList<>(); //저장소를 list로 가져옴
	
	@Override
	public void run() {
		System.out.println("Program Start!");
		
		int menu; //메뉴 정수선언
		
		do {
			try {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택(번호로 받기)
			menu = sc.nextInt();
			
			//선택한 메뉴에 따른 기능을 실행
			runMenu(menu);
			}catch(InputMismatchException e){
				menu = EXIT-1; //종료 메뉴가 아닌 아무 메뉴를 추가
				sc.nextLine(); //앞에서 잘못 입력한 내용을 비워준다.
				System.out.println("Wrong Input1"); //잘못된 입력값이라고 안내 출력
			}
			
		}while( menu != EXIT );
		System.out.println("Program exit!");
		sc.close();
	}
	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Insert Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. EXIT");
		System.out.println("Menu select : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insertStudent();
			//학생 학년,반,번호 이름 입력
			//리스트에 추가
			break;
		case 2 : 
			//수정할 학생 정보 입력
			//찾은 후 수정
			updateStudent();
			break;
		case 3 : 
			//삭제할 학생 정보 입력
			//찾은 후 삭제
			deleteStudent();
			break;
		case 4 : //나가기
			System.out.println("EXIT");
			break;
		default: //다른 번호를 입력 했을 시 틀렸다고 출력
			System.out.println("Wrong Number!");
		}
	}
	private void deleteStudent() {
		//삭제할 학생 정보 입력하기(학년, 반, 번호)
		System.out.print("input grade : ");
		int grade = sc.nextInt();
		System.out.print("input class : ");
		int classNum = sc.nextInt();
		System.out.print("input number : ");
		int number = sc.nextInt();

		//삭제할 학생정보를 이용하여 학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null); //이름이 없어도 구별할 수 있음
		
		//삭제를 시도해서 성공하면 성공했다고, 실패하면 실패했다고 알려준다.
		if(list.remove(tmp)) {
			//삭제 성공
			System.out.println("Delete success!!");
			return;
		}
		System.out.println("Delete fail"); //삭제 실패!
	}
	
	private void updateStudent() {
		//수정 할 학생정보 입력(학년, 반, 번호)
		System.out.print("input grade : ");
		int grade = sc.nextInt();
		//학생 반 입력
		System.out.print("input class : ");
		int classNum = sc.nextInt();
		//학생 번호 입력
		System.out.print("input number : ");
		int number = sc.nextInt();

		
		//수정할 학생이 있는지 없는지 확인.
		//학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);
		int index = list.indexOf(tmp);
		//없으면 종료
		if(index == -1) {
			System.out.println("Update fail!");
			return; //종료
		}
		//수정될 학생 정보를 입력(학년, 반, 번호, 이름)
		//수정 할 학생정보 입력(학년, 반, 번호)
		System.out.print("input grade : ");
		grade = sc.nextInt();
		System.out.print("input class : ");
		classNum = sc.nextInt();
		System.out.print("input number : ");
		number = sc.nextInt();
		
		//학생 정보를 수정
		//수정될 학생 정보가 이미 있는 학생인지 확인
		//수정될 정보를 이용하여 학생 객체를 생성
		tmp = new Student(grade, classNum, number, name); //위에 있는tmp와 다른거임
		//학년, 반, 번호가 일치하는 학생이 있는지 확인해서 있으면 종료
		if(list.contains(tmp)) {
			System.out.println("Update fail!");
			return;
		}
		list.get(index).update(grade, classNum, number, name);
	}

	private void insertStudent() {
		//추가할 학생의 정보를 입력해야한다(학년, 반, 번호, 이름)
		//등록할 학생 학년 입력
		System.out.print("input grade : ");
		int grade = sc.nextInt();
		//학생 반 입력
		System.out.print("input class : ");
		int classNum = sc.nextInt();
		//학생 번호 입력
		System.out.print("input number : ");
		int number = sc.nextInt();
		//학생 이름 입력
		System.out.print("input name : ");
		sc.nextLine(); //number를 입력하고 난 뒤 엔터를 처리하기 위해(nextLine)
		String name = sc.nextLine();
		
		//입력한 정보를 이용하여 학생 객체를 생성
		Student std = new Student(grade, classNum, number, name);
		
		//학생리스트에 추가
			//학생이 있는지 없는지 확인해서 없으면 추가
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("Insert success!");
			return;
		}
		//추가 성공하면 추가했다고, 실패하면 실패했다고 콘솔창에 출력
		System.out.println("Insert fail!!");
		
	}
}
