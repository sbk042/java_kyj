package day22.practice2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day22.practice2.vo.Phone;

public class PhoneManager implements Program {
	
	//스캐너를 계속 생성 할 수 없어 밖에 private을 이용해 한 번 만 입력
	private Scanner sc = new Scanner(System.in);
	//4를 EXIT라고 강조하기 위해 설정
	private static final int EXIT = 4;
	//Phone 저장소를 list로 가져오기
	private ArrayList<Phone> list = new ArrayList<>();
	
	@Override
	public void printMenu() { //먼저 안내문구 출력
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 프로그램 종료");
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
			insertPhone(); //전화번호 추가,등록
			break;
		case 2 : 
			updatePhone(); //전화번호 수정
			break;
		case 3 :
			searchPhone(); //전화번호 검색
			break;
		case 4 :
			System.out.println("bye~");
			break; //프로그램 종료 빠져 나가기
		default : System.out.println("Wrong menu!");
		}
		
	}

	private void insertPhone() {
		//추가할 전화번호 정보 입력(이름, 핸드폰 번호)
		System.out.println("input phone number : ");
		String phoneNumber = sc.nextLine();//-를 받기 위해서는 int가 아닌 String으로 입력 받아야 한다.ex)010-1234-5678
		//이름 입력 받기
		System.out.println("input name : ");
		String name = sc.nextLine();
		
		//입력한 정보를 이용하여 전화번호부 객체를 생성
		Phone std = new Phone(phoneNumber, name);
		
		// 전화번호부에 추가
			//번호가 있는지 없는지 확인해서 없으면 추가
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("Insert success!");
			return;
		}
		//추가에 성공했다면 성공했다고 안내문구, 실패하면 실패했다고 안내문구 출력
		System.out.println("Insert fail!");
	}

	private void updatePhone() {
		//수정할 정보를 입력 ( 전화번호, 이름 )
		System.out.println("input number : ");
		String phoneNumber = sc.nextLine();
		System.out.println("input name : ");
		String name = sc.nextLine();
		
		//수정될 번호가 있는지 확인
		//전화번호 객체 생성
		Phone tmp = new Phone(phoneNumber, name);
		//저장된 전화번호부 라스트 안에 수정될 번호가 있는지 indexOf롤 활용하여 찾기
		int index = list.indexOf(tmp);
		//없으면 종료
		if( index == -1 ) {//맞는 정보가 없을 때 종료 해버리기
			System.out.println("Update fail!");
			return; //빠져나가기
		}
		// 맞는 정보가 있으면 수정하기
		// 수정할 정보를 입력
		System.out.println("input phoneNumber : ");
		String phoneNumber1 = sc.nextLine();
		System.out.println("input name : ");
		String name1 = sc.nextLine();
		
	}
	private void searchPhone() {
		
		
	}

}
