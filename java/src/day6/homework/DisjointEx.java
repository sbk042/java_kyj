package day6.homework;

import java.util.Scanner;

public class DisjointEx {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하세요.
		 * 서로소 : 최대 공약수가 1인 두 수의 관계
		 * input 2 numbers : 3 4
		 * Disjoint! (서로소)
		 * input 2 numbers : 8 4
		 * Not Disjoint! (서로소 아님)
		 */
		
		//정수 선언
		int num1, num2;
		// 입력받을 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 안내문구 출력
		System.out.println(" input 2 numbers : ");
		// 정수 받기
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		// 조건문 작성
		if(num1,num2 > 2 && num1,num2 % 2 == 0) {
			System.out.println();
		}
		
		
		
		
		
		// 닫기
		sc.close();

	}

}
