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
		if ( num1 >= num2 ) {
			System.out.println(num1);
		}
		else{
			System.out.println(num2);
		}
		sc.close();
		
		// 강사님 버전
		int num1; int num2;
		int max; // 두 수 중 큰 수를 저장할 변수
		Scanner sc = new Scanner(System.in);
		// 두 정수를 입력
		System.out.println("input 2 integer numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//큰 수를 max에 저장
		//num3이 num4보다 크거나 같으면 max에 num1를 저장
		if(num1>=num2) {
			max = num1;
		}
		//아니면 max에 num4를 저장
		else {
			max = num2;
		// max를 출력
		System.out.println("The greater number of" + num1 + " or " + num2 + "is" + max);
		max = 100;
		max = num1 >= num2 ? num1 : num2;
		sc.close();
		}
	}

}
