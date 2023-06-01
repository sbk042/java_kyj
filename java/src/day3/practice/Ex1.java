package day3.practice;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적이 60점이상인지 확인하는 코드를 작성하세요.
		 * 예 : 
		 * input score :
		 * 65
		 * Do you pass 65 points? true
		 * 
		 * input score : 
		 * 45
		 * Do you pass 45 points? false
		 */
		
		// 먼저 안내문구 출력
	    System.out.println("input scroe : ");
	    // 콘솔에서 입력받을 수 있는 스캐너 생성
	    Scanner sc = new Scanner(System.in);
	    // 성적 입력 받기
	    int score = sc.nextInt();
	    // 성적이 65점 이상인가를 확인
	    boolean result = score >= 60;
	    // True, False 결과 출력
	    System.out.println("Do you pass " + score + " points? " + result);
	    
	    sc. close();
	    

	}

}
