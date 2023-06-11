package day8.homework;

import java.util.Scanner;

public class MethodMonth {

	public static void main(String[] args) {
		/* 월을 입력받아 월에 맞는 영어를 출력하세요.
		 * 단, 메서드 이용
		 * 예 : 
		 * input month : 
		 * 3
		 * March
		 */
		
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println(" input month : ");
		month = sc.nextInt();
		
		
		System.out.println();
		
		sc.close();

	}

		
	/** 월이 주어지면 주어진 월에 맞는 계절을 알려주는 메서드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 계절 = > Spring 
	 * 메서드명 : getSeason
	 * */
	public static void printEvenNumber (int month) {
		 switch( month ) {
		 case 1 : month = '1';
		 System.out.println("Jaunary");
		 break;
		 case 2 : month = '2';
		 System.out.println("Febuary");
		 break;
		 case 3 : month = '3';
		 System.out.println("March");
		 break;
		 case 4 : month = '4';
		 System.out.println("April");
		 break;
		 case 5 : month = '5';
		 System.out.println("May");
		 break;
		
		 }
		 
		
	}

}
