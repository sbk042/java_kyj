package day25.StudentProgram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.StudentProgram.vo.Student;


public class StudentController {
	/*대학생 관리 프로그램을 작성하세요.
	 * 기능 - 학생등록, 학생확인, 종료
	 * 학생 - 학번, 과, 이름
	 * */
	
	//먼저 스캐너와 변수들을 선언한다.
	private Scanner sc = new Scanner(System.in);

	public void run() {
		int menu; //switch문을 사용하기 위해서는 do while 문 밖에 메뉴를 정수로 선언해야한다.
		String name, num, major;
		//학생정보를 관리하는 리스트를 Student로 만든다.
		List<Student> list = new ArrayList<Student>(); 
		//학생 객체를 만든다
		Student tmp;
		do { 
			//1.)메뉴출력
			System.out.println("Menu");
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. EXIT");
			System.out.print("select Menu : ");
			//메뉴 선택(메뉴를 입력받는 것) = Scanner가 필요하다
			Scanner sc = new Scanner(System.in);
			menu = sc.nextInt(); //메뉴 입력 받기
			//2.)선택된 메뉴에 따른 기능을 실행
			switch(menu) { //switch문을 사용하여 가독성 높게 작성
			case 1 : //메뉴가 1일때
				//학생 정보를 입력
				//학번(문자열, 공백이 없는)
				System.out.println("input number : ");
				num = sc.next(); //공백이 없으니까 next로 받는다. 앞에 공백을 알아서 처리해줌
				//이름(문자열, 공백이 있는 (외국인이 있을 수 있음))
				System.out.println("input name : ");
				sc.nextLine(); //공백 처리 해줘야함
				name = sc.nextLine(); //공백이 있으니까 nextLine
				//과(문자열, 공백이 있는)
				System.out.println("input major : ");
				major = sc.nextLine();
			
				//학생정보 리스트에 저장 (학생정보 리스트가 필요하다.)
				//위에 리스트 생성 List<Student> list = new ArrayList<Student>(); 
				//입력한 정보를 이용하여 학생 객체를 생성한다.
				tmp = new Student(num, name, major);
				//리스트에 학생 객체를 추가한다.
				list.add(tmp);
				System.out.println(list);
				
				break;
			case 2 : //메뉴가 2일때
				//학생 전체를 확인한다.
				//뭐를 이용한다? => 반복문
				for(Student tmp2 : list) {
					System.out.println(tmp2);
				}
				break;
			case 3 : //메뉴가 3일때
				break;
			default :
				System.out.println("Wrong Menu!!!");
			}
			
		}while(menu != 3);//메뉴가 3이 아닐 때 까지 반복한다.
		sc.close();
	}
}

