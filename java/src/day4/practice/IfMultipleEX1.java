package day4.practice;

import java.util.Scanner;

public class IfMultipleEX1 {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num가 2의 배수인지 아닌지 판별하는 코드를 작성하세요.
		// 2의 배수 확인 예제(홀짝 판별)
		
		int num;
		System.out.println(" Input a number : ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println(num + " is multi of 2 ");
		}
		else {
			System.out.println(num + " is not multi of 2 ");
	    }
		
		
		sc.close();
		

	}

}
