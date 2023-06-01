package day3.homework;

import java.util.Scanner;

public class Ex1_Conditional {

	public static void main(String[] args) {
		/* 성별(M:남성,W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		 * Input gender :
		 * M
		 * Are you a woman? false
		 * 
		 * Input gender : 
		 * W
		 * Are you a woman? true
		 */
		
		// 안내 문구 출력
		System.out.println(" Input gender : ");
		// 문자 선언
		String gender = "W";
		//콘솔에 입력받을 수 있는 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 문자 입력 받기
		gender = sc.next();
		// 참 거짓
		if ( gender == "W" ) {
			System.out.println("Are you a woman? true ");
		}
		if ( gender != "W" ) {
			System.out.println("Are you a woman? false");
		}
		
		sc.close();

	}

}
