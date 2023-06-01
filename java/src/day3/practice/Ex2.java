package day3.practice;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적이 60점이상인지 확인하는 코드를 작성하세요.
		 * 예 : 
		 * input score :
		 * 65
		 * Do you pass 65 points? pass
		 * 
		 * input score : 
		 * 45
		 * Do you pass 45 points? fail
		 */
		
		// 먼저 안내 문구 출력
		System.out.println("input score : ");
		// 콘솔에 입력 받을 수 있는 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 성적 점수 받기
		int score = sc.nextInt();
		// 성적이 65점 이상인가 체크 pass는 String을 사용
		String result = score >= 60 ? "pass" : "fail";
		// 결과 산출
		System.out.println("Do you pass " + score + " points? " + result);
		//꼭 받아주기
		sc.close();
		
		

	}

}
