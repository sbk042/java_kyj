package day3.practice;

import java.util.Scanner;

public class Ex3_2IfTeacher {

	public static void main(String[] args) {
		/* 정수 num을 입력받아서 num이 0인지, 음수인지, 양수인지를 판별하는 코드를
		 * if문을 이용하여 작성하세요.
		 */
		// num이 0이면 0이라고 출력하고
		// num이 음수이면 음수라고 출력하고
		// num이 양수이면 양수라고 출력하는 코드를 작성하세요.
		
		// int를 num으로 지정
		int num;
		// 콘솔에서 입력받을 수 있는 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 안내 문구 출력
		System.out.println(" input number : ");
		// num정수를 입력 받음
		num = sc.nextInt();
		
		// 조건문 완성
		if(num == 0) {
			System.out.println(0);
		}
        if(num < 0) {
        	System.out.println(num + " is a negative number");
        }
        if(num < 0) {
        	System.out.println(num + " is a positive number");
        }
        sc.close();
	}

}
