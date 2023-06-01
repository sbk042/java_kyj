package day3.practice;

import java.util.Scanner;

public class Ex4_even {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num이 홀수인지 짝수인지 판별하는 코드를 작성하세요.
		// < 힌트 >
		// num을 2로 나누었을 때 나머지가 0이 아니면 odd number-홀수 라고 출력하고
		// num을 2로 나누었을 때 나머지가 0이면 even number-짝수 라고 출력
		
		// 안내문구 출력
		System.out.println(" input number : ");
		// num 정수 선언
		int num;
		// 콘솔에서 입력받을 수 있는 스캐너 생성
		Scanner sc = new Scanner (System.in);
		// 정수 입력 받기
		num = sc.nextInt();
		
		// 조건문 입력
		if (num % 2 !=0) {
			System.out.println(num + " is a odd number ");
		}
		if (num % 2 == 0) {
			System.out.println(num + " is a even number ");
		}
		
		
		// 닫기
		sc.close();
		 

	}

}
