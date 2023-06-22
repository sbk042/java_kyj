package day13.homework.controller;

import java.util.Scanner;

import day13.homework.vo.VocabularyNote;
import day15.practice.Shop.controller.RunInterface;

public class VocabularyNoteController implements RunInterface {
	
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();

	public void run() {
		//반복(종료를 선택하기전까지) => 무조건 1번은 실행( do - while문 사용 )
		int menu;
		do {
			// 1.) 메뉴 출력
			printMenu();
			
			// 2.) 메뉴를 선택
			menu = sc.nextInt();
			
			// 3.) 메뉴에 따른 기능 실행
			runMenu(menu);
			
		} while( menu != 5 ); //선택한 메뉴가 (종료)5가 아닐때 반복)
		sc.close();
	}
	/** 메뉴를 추력하는 메서드
	 *  매개변수 : 없음
	 *  리턴타입 : 없음 => void
	 *  메서드명 : printMenu
	 */
	private void printMenu() {
		System.out.println(" 메뉴 ");
		System.out.println(" 1. 단어 추가");
		System.out.println(" 2. 단어 삭제");
		System.out.println(" 3. 단어 수정");
		System.out.println(" 4. 단어 출력");
		System.out.println(" 5. 프로그램 종료");
		System.out.print(" 메뉴 선택 : ");
	}
	
	/** 메뉴에 따른 기능을 실행하는 메서드
	 *  매개변수 : 우리가 선택한 메뉴 => int menu 
	 *  리턴타입 : 없음 => void
	 *  메서드명 : runMenu
	 */
	private void runMenu(int menu) {
		
		switch(menu) {
		// 메뉴가 1이면 다어 추가 기능을 실행한다.
		case 1:
			insertWord(); //단어를 추가하는 메서드를 만든 후 호출
			// 추가할 단어를 입력
			
			// 추가할 뜻을 입력
			
			// 단어장에 추가
			break;
		// 메뉴가 2이면 단어 삭제 기능을 실행한다.
		case 2 :
			System.out.println("====================");
			deleteWord();
			System.out.println("====================");
			
			break;
		// 메뉴가 3이면 단어 수정 기능을 실행한다.
		case 3 :
			System.out.println("====================");
			updateWord();
			System.out.println("====================");
			
			break;
		// 메뉴가 4이면 단어 출력 기능을 실행한다.
		case 4 :
			System.out.println("====================");
			printWord();
			System.out.println("====================");
			
			break;
		// 메뉴가 5이면 프로그램을 종료한다.
		case 5 :
			System.out.println("====================");
			System.out.println("단어 추가 기능 실행");
			System.out.println("====================");
			break;
		// 메뉴가 그외이면 잘못된 메뉴라고 출력한다.
		default :
			System.out.println("====================");
			System.out.println("잘못된 메뉴");
			System.out.println("====================");
		}
	}
	private void insertWord() {
		// 추가할 단어를 입력
		System.out.print("단어 : "); // 안내 문구 출력
		String title = sc.next(); //단어이기 때문에 next로 받는다.
		
		// 단어에서 입력한 엔터를 처리
		sc.nextLine(); // 공백을 포함처리 처음으로 넘어가지 않게
		
		// 추가할 뜻을 입력
		System.out.println("뜻 : "); // 안내문구 출력
		String meaning = sc.nextLine();
		
		// 단어장에 추가 (단어장 필요 )
		int result = note.insert(title, meaning);
		
		switch(result){
			case 1 :System.out.println("단어 추가 성공!"); break;
			case -1 : System.out.println("의미 추가 성공!"); break;
			case 0 : System.out.println(" 단어 추가 실패! "); break;
			
		}
	}
	private void printWord() {
		//서브메뉴 출력
		printSubMenuPrint();
		//서브메뉴 선택
		int submenu = sc.nextInt();
		switch(submenu) {
		//서브메뉴가 1이면  전체 출력
		case 1 :
			note.print();  //전체 출력 기능 이용
			break;
		//서브메뉴가 2이면 검색
		case 2 :
			// 검색할 단어
		    System.out.println("검색 단어 : ");
			String title = sc.next();
			// 출력
			note.search(title);
			break;
		}
	}
	private void printSubMenuPrint() {
		System.out.println("=============");
		System.out.println("서브메뉴");
		System.out.println(" 1. 전체 출력");
		System.out.println(" 2. 단어 검색");
		System.out.println("서브 메뉴 선택 : ");
	}
	private void deleteWord() {
		// 삭제할 단어 입력
		System.out.println("삭제 단어 : "); // 안내문구 출력
		String title = sc.next(); //단어니까 next로 받기
		
		// 해당 단어 삭제
		if(note.delete(title)){
			System.out.println("단어 삭제 완료!");
		}else {
			System.out.println("단어 삭제 실패!");
		}
	}
	private void updateWord() {
		// 서브메뉴 출력
		printSubMenuUpdate();
		// 서브메뉴 입력
		int submenu = sc.nextInt();
		// 서브메뉴에 따른 기능 실행
		switch(submenu) {		
			//단어 수정
		case 1 : 
			// 수정할 단어
			System.out.println("수정할 단어 : "); // 안내문구 출력
			String word = sc.next();
			// 수정될 단어
			System.out.println(" 수정될 단어 : ");
			String updateWord = sc.next();
			// 단어장에 있는 단어 수정기능을 실행
			if(note.updateTitle(word, updateWord)) {
				System.out.println("단어 수정 성공!");
			}else {
				System.out.println("단어 수정 실패!");
			}
			break;
			//뜻 수정
		case 2 : 
			// 뜻을 수정할 단어를 입력
			System.out.println("단어 : ");
			String title = sc.next(); //단어니까 next로 입력받음
			
			// 단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료한다.
			if(!note.search(title)) { // 단어가 없으면
				System.out.println("없는 단어입니다.");
				return; //없으면 종료
			}
			
			// 수정할 뜻의 번호를 입력
			System.out.println("수정할 뜻 번호 선택 : ");
			int num = sc.nextInt();
			
			//엔터 자리
			sc.nextLine();
			
			// 수정될 뜻을 입력
			System.out.println("수정할 뜻 : ");
			String meaning = sc.nextLine(); // 뜻은 공백을 포함 하기 때문에 입력 받기 전 엔터자리 확보
			
			// 단어장에서 수정
			if(note.updateMeaning(title, num, meaning)) {
				System.out.println("뜻 수정 실패!");
			}else {
				System.out.println("뜻 수정 성공!");
			}
			break;
			
			//뜻 삭제
		case 3 : 
			// 뜻을 삭제할 단어를 입력
			System.out.println("단어 : ");
			String title2 = sc.next(); //단어니까 next로 입력받음
			
			// 단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료한다.
			if(!note.search(title2)) { // 단어가 없으면
				System.out.println("없는 단어입니다.");
				return; //없으면 종료
			}
			// 수정할 뜻의 번호를 입력
			System.out.println("수정할 뜻 번호 선택 : ");
			int num2 = sc.nextInt();
			if(!note.deleteMeaning(title2, num2)) {
				System.out.println("뜻 삭제 실패!");
			}else {
				System.out.println("뜻 삭제 성공!");
			}
			break;
		}
	}
	private void printSubMenuUpdate() { // 서브 메뉴 출력
		System.out.println("서브메뉴");
		System.out.println("1. 단어 수정 ");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("서브 메뉴 선택 : ");
	}
}
