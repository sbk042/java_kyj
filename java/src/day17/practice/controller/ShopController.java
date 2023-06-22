package day17.practice.controller;

import java.util.Scanner;

import day15.practice.Shop.vo.Customer;
import day15.practice.Shop.vo.Product;
import day15.practice.Shop.vo.Sales;
import lombok.Data;

@Data

public class ShopController implements RunInterface {

	private Scanner sc = new Scanner(System.in); // 밖에 스캐너 생성
	private Product list[] = new Product[10]; // 제품 리스트 저장소 10개 설정
	private int count = 0; //저장된 제품 개수 (아직 아무것도 저장된 제품 개수가 없음)
	private Customer customerList[] = new Customer[10]; //최대 10명의 고객 관리
	private int customerCount = 0; //저장된 고객 수
	private Sales salesHistory[] = new Sales[100]; //판매기록
	private int salesCount;//기록된 판매수
	private int totalPrice; //매출 금액
	
	private ShopService shopService = new ShopServiceImp();
	
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
			//입고할 제품 정보를 입력받아 제품 객체를 생성
			//제품 리스트와 제품 수, 입고된 제품을 주고 제품 입고를 관리하라고 시킴
			shopService.store(list,count, product);
		
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
		
	
	private void registerCustomer() { //고객 등록 기능 구현
		//등록할 고객 (이름,전화번호) 입력
		System.out.println("고객 이름 : ");
		String name = sc.next();
		System.out.println("번호 : ");
		String phoneNumber = sc.next();
		
		//고객을 등록(고객리스트에)
		//이미 등록된 전화번호이면 등록을 X
		for(int i =0; i < customerCount; i++) { //등록된 고객수 보다 작을 때까지 조회
			//customerList[i] : 고객 리스트에서 i번지에 있는 고객 정보
			//customerList[i].getPhoneNumber() : i번지 고객의 전화번호
			//i번지 고객의 저화번호와 등록하려는 고객의 전화번호가 같으면 등록 실패
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				System.out.println("등록된 번호! 고객 등록 실패!");
				return;
			}
		}
		
		//새 전화번호이면 등록 가능(전화번호는 중복X)
		// 입력받은 고객 정보를 이용하여 고객 객체를 생성한 후 , 마지막 고객 다음에 새고객을 추가
		// 등록된 고객의 수를 증가
		customerList[customerCount++] = new Customer(name, phoneNumber);
		
	}
	private void printSales() {
		//매출 내역 출력
		for(int i =0; i<salesCount; i++) {
			salesHistory[i].print();
		}
		//누적 매출 내역 출력
		System.out.println("누적 매출액 : " + totalPrice);
	}
	
	//제품을 검색해서 조회하는 메서드
	private void printProduct() {
		//검색할 제품을 입력
		System.out.print("제품명 : ");
		sc.nextLine(); //엔터. 이전 입력에서 엔터를 쳤기 때문에 엔터 제거
		String name = sc.nextLine(); 
		
		//입력한 검색어에 맞는 제품을 출력
		//등록된 제품들 중에 검색어와 일치하는 제품이 어디 있는지 확인
		int index = indexOf(name);
		
		//제품이 있으면 제품 정보를 출력
		if(index >= 0 ) {
			list[index].print();
			return; //
		}
		//찾는 제품이 없으면 없는 제품이라고 출력
		System.out.println("없는 제품입니다!");
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
		int index = indexOf(name); //메서드"indexOf"를 이용해 제품명 찾기
		
		//있으면 (입고할 제품 수량 만큼 해당 제품에 입고 + )
		//위치가 0이상이면
		if(index != -1) { // -1이 아니라면
			list[index].store(amount); //제품을 찾고 입고 수량 입력
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
		for(int i = 0; i < count; i++) { //위에 저장된 제품 개수"count" 보다 작아야된다.
			if( list[i].getName().equals(name)) { //입력받은 i가 가지고 있는 정보 name에 있다면 i로 출력
				return i;
			}
		}
		return -1; //그렇지 않다고 -1를 출력한다.
	}
	
	
	private void sell(){
		//판매한 제품명을 입력
		System.out.println("판매한 제품 : "); //안내문구 출력
		sc.nextLine();
		String name = sc.nextLine(); 
		
		//제품 개수 입력
		System.out.println("수량 : ");
		int amount = sc.nextInt();

		//판매한 고객 정보 입력
		System.out.println("고객 번호 : "); //안내문구 출력
		String phoneNumber = sc.next(); //
		
		//있는 제품인지 확인
		int index = indexOf(name);
		if(index < 0) {
			System.out.println("제품명 오류!");
			return;
		}
		if(amount <= 0) {
			System.out.println("제품 수량 오류!");
			return;
		}
		
		//있는 고객인지 확인
		int customerIndex = indexOfCustomer(phoneNumber);
		if(customerIndex < 0) {
			System.out.println("전화번호 오류!");
			return;
		}
		
		//판매 내역에 추가 하기 위해서는
		//제품 정보 필요
		//복사 생성자를 이용해서 제품 정보를 복사(깊은 복사)
		Product product = new Product(list[index]); //창고에 있는 제품 정보이다.
		product.setAmount(amount);
		
		//고객 정보 필요
		Customer customer = customerList[customerIndex];
		
		Sales sales = new Sales(customer, product);
		salesHistory[salesCount++] = sales;
		
		//판매된 개수만큼 재고량에서 배줘야함.
		list[index].release(amount);
		
		//매출금액을 추가
		totalPrice += sales.getTotalPrice();
		
	}
	
	private int indexOfCustomer(String phoneNumber) {
		for(int i = 0; i<customerCount; i++) {
			//고객의 번호가 같으면
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}
}

