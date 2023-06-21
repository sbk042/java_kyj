package day16.homework.controller;

import java.util.Scanner;

import day15.practice.Shop.vo.Product;

public class BeverageMachineEx {

		/* 음료수를 뽑는 자판기 프로그램을 작성하세요.
		 * 단, 음료수 자판기에 음료수는 사이다, 콜라, 환타가 고정이라고 가정.
		 * 메뉴를 선택하면 음료수와 잔액이 나옴(출력)
		 * 
		 * 메뉴
		 * 1. 금액 투입
		 * 2. 메뉴 선택
		 * 3. 제품 입고
		 * 4. 프로그램 종료
		 * 
		 * 메뉴 선택 : 2
		 * 1. 사이다
		 * 2. 콜라
		 * 3. 환타
		 * 음료 선택 : 1
		 * 사이다를 선택했습니다.
		 * 사이다가 나옵니다. [금액이 충분한 경우]
		 * 잔돈 xxx가 나옵니다.
		 * 
		 *  금액이 부족합니다. [금액이 부족한 경우]
		 * 잔돈 xxx가 나옵니다.
		 */
	
	private Scanner sc = new Scanner(System.in); //스캐너를 생성
	private Product list[] = new Product[];
	private int count;
	
	public void run() {
		System.out.println("프로그램 시작!!");
		
		int menu = -1;
		final int EXIT = 6; //상수 6을 만들었다.( 상수를 의미하는 final)
		//반복 : 선택한 메뉴가 종료가 아닐때까지 반복한다
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//선택한 메뉴에 따른 기능을 시행
			runMenu(menu);
			
		}while( menu != 6 );
		System.out.println("프로그램 종료!!");
		sc.close();
	}
	// 메뉴출력 메서드
	private void printMenu() {
		System.out.println("===============");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) {
		System.out.println("=================");
		
		switch(menu) {
		case 1 : //System.out.println("금액 투입 기능 구현 예정");
			sell();

			break;
		case 2 : //("메뉴 선택 기능 구현 예정");
			choice();
		
			break;
		case 3 : //("제품 입고 기능 구현 예정");
			store();
			break;
		case 4 : //("프로그램 종료 기능 구현 예정");
		
			break;
		default : 
			System.out.println("잘못된 메뉴!");

		}
	}

}
