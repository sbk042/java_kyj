package day4.IfEx;

import java.util.Scanner;

public class IfAdultEx {

	public static void main(String[] args) {
		// 나이를 입력받아 나이가 20세 이상이면 adult를 출력하고
		// 20세 미만이면 minor로 출력하는 코드를 작성하세요.
		// if-else문을 이용
		
		//int를 age로 지정 나이를 정수로 지정
		int age;
		//안내문구 출력
		System.out.println(" Input your age : ");
		// 입력받을 스캐너 출력
		Scanner sc = new Scanner(System.in);
		// 나이를 정수로 받음
		age = sc. nextInt();
		// if-else 조건문 작성
		if (age>=20) {
			System.out.println("adult!");
		}
		else {System.out.println("minor!");
		}
		sc.close();
		

	}

}
