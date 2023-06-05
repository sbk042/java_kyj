package day5.practice;

import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 프로그램 종료를 선택하기 전까지 반복적으로
		 * 실행되는 코드를 작성하세요.
		 * 
		 * Menu
		 * 1. Start
		 * 2. Save
		 * 3. Exit
		 * 
		 * Select Menu : 
		 * 1 [입력 ]
		 * Program Start!
		 * 
		 * <메뉴를 출력하는 예제>
		 * 반복 횟수 : menu가 3이 아닐때가지 반복
		 * 규칙성 :
		 *  - 메뉴를 출력
		 *  - 메뉴를 입력
		 *  - 입력받은 메뉴에 다라 콘솔에 출력
		 *     - 입력받은 메뉴가 1이면 Program Start!
		 *     - 입력받은 메뉴가 2이면 Program Save!
		 *     - 입력받은 메뉴가 3이면 Program Exit!
		 */
		
		// 숫자 정수 선언
	    int menu = 0; // 3이 아닌 값으로 초기화
	    // 입력할 스캐너 창 설정
	    Scanner sc = new Scanner(System.in);
	    // 안내문구 입력(메뉴를 출력)
	    while(menu != 3) {
	    System.out.println("Menu");
	    System.out.println("1. Start");
	    System.out.println("2. Save");
	    System.out.println("3. Exit");
	    System.out.println("Select Menu : ");
	    
	    // 문자 입력 받기 (메뉴를 입력)
	    menu = sc.nextInt();
	    
	    // switch문 입력 ( 입력받은 메뉴에 다라 콘솔에 출력)
	    switch ( menu ) {
	    // 입력받은 메뉴가 1이면 Program Start!
	    case 1 :
	    	System.out.println("Program Start!");
	    	break;
	    	// 입력받은 메뉴가 2이면 Program Start!
	    case 2 :
	    	System.out.println("Program Start!");
	    	break;
	    	// 입력받은 메뉴가 3이면 Program Start!
	    case 3 :
	    	System.out.println("Progrma Exit!");
	    	break;
	    	}
	    }
	    
    	sc.close();
    }

}

