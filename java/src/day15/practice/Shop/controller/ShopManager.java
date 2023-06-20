package day15.practice.Shop.controller;

import java.util.List;
import java.util.Scanner;

import day15.practice.Shop.vo.Product;

public class ShopManager {

	private Scanner sc = new Scanner(System.in); // 밖에 스캐너 생성
	private Product list[] = new Product[10]; // 제품 리스트 저장소 10개 설정
	private int count = 0; //저장된 제품 개수 (아직 아무것도 저장된 제품 개수가 없음)
	
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
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 등록");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private void runMenu(int menu) {
		System.out.println("=================");
		
		switch(menu) {
		case 1 : System.out.println("제품 판매 기능 구현 예정");
			sell();
			//고객이름 입력
			//고객이 산 제품 입력
			//리스트에 추가
			break;
		case 2 : //("제품 입고 기능 구현 예정");
			
			store();
		
			break;
		case 3 : //("제품 조회 기능 구현 예정");
		
			printProduct();
			break;
		case 4 : //("매출 조회 기능 구현 예정");
		
			printSales();
			break;
		case 5 : //("고객 등록 기능 구현 예정");
		
			registerCustomer();
			break;
		case 6 : System.out.println("프로그램 종료 기능 구현 예정");
			break;
		default:
			System.out.println("잘못된 메뉴!");
		}
	}
		
	
	private void registerCustomer() {
		// TODO Auto-generated method stub
		
	}
	private void printSales() {
		// TODO Auto-generated method stub
		
	}
	private void printProduct() {
		// TODO Auto-generated method stub
		
	}
	private void store() {
		//입고할 제품명 입력
		System.out.println("제품명 입력 : "); //안내문구 출력
		String name = sc.nextLine(); //제품명 입력 받기
		
		sc.nextLine(); //엔터도 입력받은 걸로 인식
		
		//입고할 제품 수량
		System.out.println("수량 입력 : "); //안내문구 출력
		int amount = sc.nextInt(); //제품 수량 입력 받기
		
		//혹시 입력을 잘못했을 경우
		if(amount < 0) { //입고량이 음수면 안되기 때문에 음수이면 오류
			System.out.println("입고 수량 오류!");
			return;
		}
		
		//제품 리스트에서 입고할 제품명이 있는지 찾는다.(메서드 만들기)
		//제품 배열에 있는 제품명과 입고할 제품명이 같은지를 
		// 확인해서 같으면 위치를 기억
		int index = indexOf(name); //메서드를 이용해 제품명 찾기
		
		//있으면 (입고할 제품 수량 만큼 해당 제품에 입고 + )
		//위치가 0이상이면
		if(index != -1) { // -1이 아니라면
			list[index].store(amount); //제품을 찾고 입고
			System.out.println("입고 완료!");
			return;
		}
		//없으면 (제품 리스트에 제품 정보를 추가, 입고할 수량도 함께)
		//위치가 -1이면
		//최대치로 등록되어 있으면 (꽉 참)
		if(count == list.length) { //저장된 제품이 pull
			System.out.println("제품 리스트 pull"); //다 찼다고 안내문구 출력
			return; //안내문구 출력 후 빠져나가기
		}
		//모델명 입력
		System.out.println("새 제품 등록 : ");
		System.out.println("모델명 : ");
		
		sc.nextLine(); //엔터도 입력 받은 걸로 인식
		String modelName = sc.nextLine(); //입력받기
		
		//가격을 입력
		System.out.println("가격 : ");
		int price = sc.nextInt();
		
		//분류 입력
		System.out.println("분류 : ");
		String category = sc.next();
		
		//제품 리스트에 추가
		list[count++] = new Product(name, modelName, price, amount, category);
		System.out.println("제품 추가 후 입고 완료!");
		
	}
	/** 제품 리스트에 제품명과 일치하는 제품이 있으면 번지를,
	 *  없으면 -1를 알려주는 메서드
	 *  매개변수 : 제품명 => String name 
	 *  리턴타입 : 제품이 있는 번지나 -1를 리턴해야함 => 정수 => int
	 *  메서드명 : indexOf
	 */
	public int indexOf(String name) {
		for(int i = 0; i < count; i++) { //위에 저장된 제품 개수 까지
			if( list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	
	private void sell(){
		//먼저 판매한 고객 이름 입력
		System.out.println("고객 이름 : "); //안내문구 출력
		String name = sc.next(); //고객이름은 단어이기 대문에 next로 받는다.
		
		// 입력한 단어 엔터처리
		sc.nextLine(); //공백을 포함처리. 처음으로 넘어가지 않게 엔터도 입력으로 받는다.
		
		//판매한 가전제품을 입력
		System.out.println("판매한 제품 : "); //안내문구 출력
		String homeAppliances = sc.next(); 
		

		}
	}

