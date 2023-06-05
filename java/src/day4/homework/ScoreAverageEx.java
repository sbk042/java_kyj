package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		/* 국어,영어,수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		 * 성적은 정수
		 */
		
		// 국어,영어,수학 정수로 지정
		int num1; int num2; int num3;
		//안내문구출력
		System.out.println("Input your score : ");
		//입력받은 스캐너 설치
		Scanner sc = new Scanner(System.in);
		//정수 입력 받기 (성적은 정수)
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		//평균 내기
		int sub = ((num1+num2+num3)/3);
		System.out.println(sub);
		
		//닫기
		sc.close();
		
		// 강사님 버전
		
		int kor, eng, math;
		double avg;
		Scanner sc =new Scanner(System.in);
		// 국어,영어,수학순으로 성적을 입력
		System.out.println("Input score (kor, eng, math) ex : 100 90 80 :");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		// 평균을 계산
		avg = (kor + eng + math) / (double)3.0; //(double)로 형변환도 가능. 3.0을 이용도 가능.
		
		// 평균을 출력
		System.out.println("avg : " + avg);
		
		sc.close();

	}

}

