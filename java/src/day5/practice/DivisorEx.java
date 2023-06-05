package day5.practice;

import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		// 정수 num를 입력받아 num의 약수를 출력하는 코드를 작성하세요.
		//약수 : A를 B로 나누었을 때 나머지가 0이면 B는 A의 약수이다.
		//12의 약수 : 1,2,3,4,6,12
		/* 반복횟수 : i는 1부터 num까지 1씩증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 *         =>num를 i로 나누었을때 나머지가 0과 같다면 i를 출력
		 * 
		 * 소수 : 약수가 2개인 수, 1을 제외하고 처음 구한 약수가 자신인 수
		 */
		
		//정수 입력
		int num; int i; //i를 초기화
		//입력 스캐너 만들기
		Scanner sc = new Scanner(System.in);
		//안내 문구 출력
		System.out.println(" Input positive number : ");
		//정수 입력 받기
		num = sc.nextInt();
		// 반복문, i는 1부터 num까지 1씩 증가.
		i = 1;
		while(i <= num) {
			if(num % i == 0) {
				System.out.println(i);
				
			}
			++i; 
			
		}
		sc.close();

	}


}
