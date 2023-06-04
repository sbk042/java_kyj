package day4.homework;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		//두 정수를 입력받아 두 정수 중 큰 수를 출력하는 코드를 작성하세요.
		
		// 두 정수 선언
		int num1; int num2; 
		//안내문구 출력
		System.out.println(" Input your two number : ");
		//입력 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 정수 입력 받기
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		// 두 정 수 중 큰 수를 출력하는 코드 작성
		if ( num1 > num2 ) {
			System.out.println(num1);
		}
		else{
			System.out.println(num2);
		}
		sc.close();
		
	}

}
