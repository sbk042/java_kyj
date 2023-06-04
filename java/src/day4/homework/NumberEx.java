package day4.homework;

import java.util.Scanner;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 짝수이면 num에 2를 나누고,
		 * 정수 num가 홀수이면 num에 1을 더한 후,num를 출력하는 코드를 작성하세요. 
		 */
		
		// num 정수 선언
		int num;
		// 안내문구 출력
		System.out.println("Input a number : ");
		// 입력받을 스캐너 출력
		Scanner sc = new Scanner(System.in);
		// 정수 입력
		num = sc.nextInt();
		// 짝수 홀수 조건문 생성
		if(num % 2 == 0) {
			System.out.println( "num" + "/" + "2" + "=" + (num / 2));
		}
		else{
			System.out.println( "num" + "+" + "1" + "=" + (num + 1));
		}
		sc.close();
		

	}

}
