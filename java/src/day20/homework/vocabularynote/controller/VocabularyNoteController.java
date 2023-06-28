package day20.homework.vocabularynote.controller;

import java.util.Scanner;

import day17.interfaceex.RunInterface;
import day20.homework.vocabularynote.vo;

public class VocabularyNoteController implements RunInterface{
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	public void run() {
		//반복(종료를 선택하기전까지) => 무조건 1번은 실행
		int menu = -1;
		do {
			try {
				//메뉴출력
				printMenu();
				//메뉴선택
				menu = sc.nextInt();
				//메뉴에 따른 기능 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 값을 입력했습니다.");
				sc.nextLine();
			}
		}while(menu != 5);
		sc.close();
	}
	/** 메뉴를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메서드명 : printmenu
	 */
	private void printMenu() {
		System.out.println("Menu");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
	}
	
	/** 메뉴에 따른 기능을 실행하는 메서드
	 * 매개변수 : 메뉴 => int meu
	 * 리턴타입 : 없음 => void
	 * 메서드명 : runMenu
	 */
	private void runMenu(int menu) {
		
		System.out.println("==============");
		switch(menu) {
		//메뉴가 1이면 단어 추가 기능을 실행
		case 1 :
			insertWord();
			break;
		//메뉴가 2이면 단어 삭제 기능을 실행
		case 2 : 
			deletWord();
			break;
		//메뉴가 3이면 단어 수정 기능을 실행
		case 3 :
			updateWord();
			break;
		//메뉴가 4이면 단어 출력 기능을 실행
		case 4 :
			printWord();
			break;
		//메뉴가 5이면 프로그램을 종료
		case 5 :
			System.out.println("프로그램 종료!");
			break;
		//메뉴가 그외이면 잘못된 메뉴라고 출력
		default : 
			System.out.println("잘못된 메뉴 선택!");
		}
		System.out.println("============");
	}
	private void insertWord() {
		//추가할 단어를 입력
		System.out.print("단어  : ");
		String title = sc.next();
		
		//단어에서 입력한 엔터를 처리
		sc.nextLine();
		
		//추가할 뜻을 입력
		System.out.print("뜻 : ");
		String meaning = sc.nextLine();
		
		//단어장에 추가
		if(note.insert(title, meaning)) {
			System.out.println("단어추가 성공!");
		}else {
			System.out.println("의미 추가 성공!");
		}
		
	}
	private void deletWord() {
		// TODO Auto-generated method stub
		
	}
	private void updateWord() {
		// TODO Auto-generated method stub
		
	}
	private void printWord() {
		// TODO Auto-generated method stub
		
	}
	

	

}
