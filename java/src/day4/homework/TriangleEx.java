package day4.homework;

import java.util.Scanner;

public class TriangleEx {

	public static void main(String[] args) {
		/* 세변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		 * 
		 * 세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
		 * Input 3 integer num :
		 * 1 2 3 
		 * Unable to create triangel.
		 * 
		 * Input 3 integer num :
		 * 2 2 3 
		 * Able to create triangle
		 */
		
		// 세변의 길이 정수 선언
		int num1; int num2; int num3;
		// 안내문구 출력
		System.out.println("Input 3 integer num : ");
		// 입력받을 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 세변의 길이 정수 받기
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		// 삼각형을 만들 수 있는지 조건문 생성
		if(( num1 + num2 ) > num3 && num3 > num1 && num3 > num2 ) {
			System.out.println("Able to create triangle");
		}
		else if(( num1 + num3 ) > num2 && num2 > num1 && num2 > num3) {
			System.out.println("Able to create triangle");
		}
		else if(( num2 + num3) > num1 && num1 > num2 && num1 > num3) {
			System.out.println("Able to create triangle");
		}
		else {
			System.out.println("Unable to create triangle");
		}
		sc.close();
		
		//강사님 버전
		
		int a, b, c;
		int max; // 세변 a, b, c중 가장 큰 변의 길이
		Scanner sc = new Scanner(System.in);
		
		//세 변의 길이를 입력
		System.out.println("Input 3 integer numbers : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		//삼각형 가능 여부를 확인 및 출력
		//세변 중 가장 큰 변의 길이를 계산
		// a가 b보다 크면 max에 a를 저장
		if(a > b) {
		   // a가 c보다 크면 a를 max에 저장
		   if(a > c) {
			   max = a;
		   }
		   //아니면 c를 max에 저장
		   else {
			   max = c;
		   }
		}
		// 아니면 b가 c보다 크면 max에 b를 저장
		else if(b > c) {
			max = b;
		}
		// 아니면 max에 c를 저장
	    else{
	    	max = c;
	    }
		//max = a > b ? (a > c ? a: c) : (b > c ? b :c);
		//작은 두변의 합 > max
		//세변의 합 - max == 작은 두 변의 합
		//세변의 합에서 max를 뺀 값이 max보다 크면 삼각형이라고 출력
		if(a + b + c - max > max) {
			System.out.println("Able to create triangle.");
		}
		//아니면 삼각형이 아니라고 출력
		else {
			System.out.println("Unable to create triangle.");
		}
		
		sc.close();

	}

}
