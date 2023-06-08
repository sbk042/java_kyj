package day7.practice;

import java.util.Scanner;

public class LCMEx {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 두 정수의 최소공배수를 구하는 코드를 작성하세요.
		 * 2의 배수 : 2, 4, 6, 8, 10 ...
		 * 공배수 : 공통으로 있는 배수
		 * 6과 8의 공배수 : 24, 48, 72, ...
		 * 최소 공배수 : 공배수 중 가장 작은 배수
		 * 6과 8의 최소 공배수 : 24 
		 */
		
		/* 방법 1.)
		 * 반복횟수 : i는 1부터 (num1*num2까지) 1씩 증가
		 * 규칙성 : i가 num1의 배수이고 i가 num2의 배수이면
		 * 	      i를 출력 후 반복문 종료
		 * 		 => i를 num1로 나누었을 때 나머지가 0과 같고
		 * 			i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 			i를 출력 후 반복문을 종료
		 * 반복문 종료 후 : 없음
		 */
		
		//두 정수 지정
		int num1,num2,i;
		//입력받을 스캐너 
		Scanner sc = new Scanner(System.in);
		//안내문구 출력
		System.out.println("input 2 number : ");
		// 정수 입력 받기
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		// 반복문 출연
		for( i = 1 ; i <= (num1*num2) ; i++ ) {//for(i = 1; ;i++) 이렇게 생략도 가능
		    if(i % num1 == 0 && i % num2 == 0) {
		    	System.out.println(i);
		    	break;
		    }
		}
		//닫기
		sc.close();
		
		
		/* 방법 2.)
		 * 반복횟수 : i는 num1부터 (num1*num2까지) num1씩 증가
		 * 규칙성 : i가 num2의 배수이면
		 * 	      i를 출력 후 반복문을 종료
		 * 	   	=>  i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 			i를 출력 후 반복문을 종료
		 * 반복문 종료 후 : 없음
		 * 10000, 15000일 때
		 * 10000부터 시작해서 30000까지 3번 반복
		 */
		
		/*
		int num1,num2,i;
		Scanner scanner = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		System.out.println(" input two number : ");
		for(i = num1; ; i+=num1) {
			if( i % num2 == 0 ) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
		*/
		

	}

}
