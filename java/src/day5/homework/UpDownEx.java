package day5.homework;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		/* UpDown게임
		 * 1~100사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		 * 랜덤한 수 : 45
		 * input : 50
		 * Down!
		 * input : 40
		 * up!
		 * input : 45
		 * Good!
		 */
		
		//정수 선언
		int num; int answer;
		// 입력받을 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 안내문구 출력
		System.out.println(" Input : ");
		// 정수 선언
		num = sc.nextInt();
		answer = sc.nextInt();
		// 정답 랜덤 돌리기
		answer = (int)(Math.random()*100) + 1;
		while(num != answer) {
			if (num < answer) {
				System.out.println(" UP! ");
			}
			else if( num > answer) {
				System.out.println(" Down! ");
			}
			else {
				System.out.println(" Good! ");
			}
		}

	}

}
