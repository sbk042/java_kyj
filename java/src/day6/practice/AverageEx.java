package day6.practice;

import java.util.Scanner;

public class AverageEx {

	public static void main(String[] args) {
		/* 국어, 영어, 수학 성적을 입력받아 평균을 구하는 코드를 작성하세요.
		 * input 3 score(kor, eng, math) : 10 20 30
		 * average : 20.0
		 * continue? ( y/n ) :
		 * y
		 * input 3 score(kor, eng, math) :  90 95 100
		 * average : 95.0
		 * continue?(y/n) : n
		 * EXIT!
		 */
		// 반복문 : menu가 n이 아니면 반복(y,n이 아닌 다른 문자를 입력하면 반복)
		// menu가 y이면 반복(y,n이 아닌 다른 문자를 입력하면 종료)
		
		// 정수 선언
		int kor, eng, math;
		char menu = 'y';
	    double avg;
		//입력받을 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// n이 나올때 까지 반복문 생성
		while(menu != 'n') { // menu가 no가 나올 때 까지
		// 안내문구 출력
		System.out.println(" input 3 score ( kor, eng, math ) : ");
		// 세 정수 입력 받기
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		// 평균을 계산
		avg = (kor + eng + math)/3.0;
		// 더 할 건지 물어보기.
		System.out.println(" continue? (y/n) : ");
		menu = sc.next().charAt(0);
		}
		//EXIT!를 출력
		System.out.println("EXIT!");
        // 닫기
		sc.close();
		

	}

}
