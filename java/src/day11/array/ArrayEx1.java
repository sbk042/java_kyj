package day11.array;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		/* 학생들의 국어 성적을 저장하기 위한 배열을 생성하세요.
		 * 학생들은 총 3명.
		 */
		// 자료형 [] 배열명 = new 자료형[개수];
		double [] studentKoreaScore = new double[3]; //배열 선언(점수를 실수로 3개 받을거임 double)
		
		Scanner sc = new Scanner(System.in); //입력받을 스캐너 생성
		
		for(int i = 0; i<3; i++) {
			System.out.println("input : ");
			// 배열명 [번지] : 변수처럼 사용
			studentKoreaScore[i] = sc.nextDouble();
		}
		
		
		for(int i = 0; i<3; i++) {
			System.out.println(studentKoreaScore[i]); //배열 사용
		}
		/* 학생 3명의 국어 점수 평균을 구하고 출력하는 코드를 작성하세요.
		 * */
		double sum = 0.0; // sum 실수로 받기 초기화
		for(int i = 0; i<3; i++) { // i는 0부터 3까지 1씩 늘어남
			sum += studentKoreaScore[i];
		}
		double average = sum / 3;
		System.out.println("average : " + average);
		
		sc.close();

	}

}
