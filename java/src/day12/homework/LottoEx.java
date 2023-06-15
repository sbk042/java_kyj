package day12.homework;

import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
		/* 로또 번호를 생성하고, 사용자가 번호를 입력하면 몇등인지 출력하는 코드를 작성하세요.
		 * 
		 * 1등 : 번호 6개
		 * 2등 : 번호 5개 + 보너스
		 * 3등 : 번호 5개
		 * 4등 : 번호 4개
		 * 5등 : 번호 3개
		 * 
		 * number : [1, 3, 40, 23, 24, 45]
		 * bonus : 2
		 * user : 1 2 3 4 5 6 
		 * losing ticket!
		 */
		
		int lotto[] = new int[6]; // 로또를 랜덤으로 받을 저장소 6개를 생성
		int user[] = new int[6]; // 사용자가 입력한 수를 저장할 배열 ( 내가 입력)
		int min = 1, max = 45; // 로또 랜덤 수 최소값 최대값 지정
		Scanner sc = new Scanner(System.in); //입력받을 스캐너 생성
		
		
		// 1.) 로또 번호 랜덤 생성 (중복x)
		
	}
}
