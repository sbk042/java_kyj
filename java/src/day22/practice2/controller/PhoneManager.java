package day22.practice2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day22.practice2.vo.PhoneBook;

public class PhoneManager implements Program {
	
	//스캐너를 계속 생성 할 수 없어 밖에 private을 이용해 한 번 만 입력
	private Scanner sc = new Scanner(System.in);
	//4를 EXIT라고 강조하기 위해 설정
	private static final int EXIT = 4;
	//Phone 저장소를 list로 가져오기
	private ArrayList<PhoneBook> list = new ArrayList<>();
	private PhoneBook pb = new PhoneBook();
	
	@Override
	public void printMenu() { //먼저 안내문구 출력
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Search");
		System.out.println("4. EXIT");
		System.out.println("Select Menu : ");
	}
	
	@Override
	public void run() {
		int menu; //메뉴 정수 선언
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//메뉴 기능 실행
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insert(); //전화번호 추가,등록
			break;
		case 2 : 
			update(); //전화번호 수정
			break;
		case 3 :
			search(); //전화번호 검색
			break;
		case 4 :
			System.out.println("EXIT");
			break; //프로그램 종료 빠져 나가기
		default : System.out.println("Wrong menu!");
		}
		
	}

	private void insert() {
		//추가할 전화번호를 정보 입력(이름, 핸드폰 번호)
		System.out.println("name : ");
		sc.nextLine();
		String name = sc.nextLine();//-를 받기 위해서는 int가 아닌 String으로 입력 받아야 한다.ex)010-1234-5678
		//전화번호 입력 받기
		System.out.println("number : ");
		String number = sc.nextLine();
		
		//전화번호부에 추가를 해서 성공하면 성공이라고
		if(pb.insertPhone(name, number)) {
			System.out.println("Insert Success!!");
		}
		//실패하면 실패했다고 출력
		else {
			System.out.println("Insert Fail!");
		}
		
	}

	private void update() {
		//이름, 수정할 이름과 수정할 전화번호를 입력
		System.out.println("name : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("update number : ");
		String updateName = sc.nextLine();
		
		System.out.println("number : ");
		String number = sc.nextLine();
		
		//전화번호부에 수정을 해서 성공하면 성공이라고
		if( pb.update(name, updateName, number)) {
			System.out.println("Update Success!!");
		}
		//실패하면 실패했다고 출력
		else {
			System.out.println("Update faill!!");
		}
	}
	private void search() {
		//검색할 이름을 입력
		System.out.print("name : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//검색 결과물 출력
		pb.print(s->s.getName().contains(name));
		//pb.print(s->true); //전체 출력
	}
}
