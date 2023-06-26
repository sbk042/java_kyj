package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자를 입력했을 때 연산 결과를 출력하는 코드를 작성하세요.
		 * 예외처리도 추가
		 * 
		 * input : 1 + 2
		 * 1 + 2 = 3
		 * input : 1 ? 2 (연산자가 잘못된 경우)
		 * Not operator!
		 * input : 1 / 0 ( 0으로 나누었을 때 )
		 * Not operator!
		 */
	
		// 1.) 두 정수와 산술연산자 입력 
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		System.out.print("input (ex : 1 + 2) : "); //안내문구 출력
	try { // 3.) 예외처리
		int num1 = sc.nextInt();
		char op = sc.next().charAt(0);
		int num2 = sc.nextInt(); //문자 입력받기
		
		// 2.) 연산자에 따른 결과를 출력
		switch(op){
		case '+' :
			System.out.println("" + num1 + op + num2 + "=" + (num1 + num2));
			break;
		case '-' : 
			System.out.println("" + num1 + op + num2 + "=" + (num1 - num2));
			break;
		case '*' :
			System.out.println("" + num1 + op + num2 + "=" + (num1 * num2));
			break;
		case '/' :
			System.out.println("" + num1 + op + num2 + "=" + ((double)num1 / num2));
			break;
		case '%' : 
			System.out.println("" + num1 + op + num2 + "=" + (num1 % num2));
			break;
		default :
			System.out.println("Not operator!");
		}
	}catch(InputMismatchException e){//예외처리 되는 것을 알아서 밑에 문구로 출력으로 처리
		System.out.println("Wrong Input!");
	}catch(ArithmeticException e){ 
		System.out.println("Not operation!");
	}catch(Exception e) {
		System.out.println("Exception");
	}
	System.out.println("EXIT!");
	test1();
	test2();
	sc.close(); //닫기
	}
	
	public static void test1() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!!!!");
			return;
		}finally { //finally는 무조건 한번은 실행이 된다.
			System.out.println("Method1 EXIT!!");
		}
	}
	public static void test2() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!!!!");
			return;
		}
		System.out.println("Method2 EXIT");
	}
}
