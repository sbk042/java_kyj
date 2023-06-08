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
	
		
		/* 두 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공통으로 있는 약수
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대 공약수 : 4
		 *    num1을 i로 나누었을 때 나머지가 0과 같고
		 *    num2를 i로 나누었을 때 나머지가 0과 같다면
		 *    i를 gcd에 저장
		 * 반복 횟수 : i는 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num1의 약수이고 i가 num2가 약수이면 i를 gcd에 저장 
		 * 반복문 종료 후 : gcd가 1이면 Disjoint를 출력하고,
		 *               아니면 not disjoint를 출력
		 */
		
		// 최대공약수를 구하는 식에서 뒷 부분인 출력 부분만 바뀌었다.
		
		     //두 정수 선언
			int num1, num2;
			int i = 1; // i는 1부터
		    int gcd = 1;
			//입력받을 스캐너 생성
			Scanner sc = new Scanner(System.in);
			//안내문구 출력 ( 두 정수를 입력하라 )
			System.out.println("input 2 numbers : ");
			// 두 정수를 입력받기
			num1 = sc.nextInt();
		    num2 = sc.nextInt();
				//반복문 (최대공약수를 구하기 위한 반복분이다) : i가 num1까지
			    while(i <= num1) {
			    	//num1을 i로 나누었을 때 나머지가 0과 같고 num2를 i로 나누었을 때 나머지가 0
			    	if(num1 % i == 0 && num2 % i == 0) {
			    		//i를 gcd에 저장
			    		gcd = i;
			    	}
			    	//i를 증가
					i++;
			    }
				// gcd가 1이면 Disjoint를 출력하고, 아니면 Not disjoint를 출력.
			    if(gcd == 1) { //gcd가 1과 같다.
			    	System.out.println("Disjoint!");
			    }else {
			    	System.out.println("Not disjoint");
			    }
				//닫기
				sc.close();
				


	}

}
