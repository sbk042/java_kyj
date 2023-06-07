package day6.practice;

import java.util.Scanner;

public class UpdownEx {

	public static void main(String[] args) {
		/* 한판이 끝나면 더할건지를 물어서 n을 입력하면 종료, y를 입력하면 이어서
		 * 게임이 진행.
		 */
		
		//정수 선엄
		/*
		int min = 1, max = 100;
		int num = min -1; // 1~100이 아닌 정술 초기화 하면 됨
		int random;
		char menu;
		//랜덤한 수를 생성( 및 출력 )
		random = (int)(Math.random()*(max - min + 1)+ min);
		System.out.println(random);
		// 입력받을 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 안내문구 출력
		System.out.println(" input(1~100) : ");
		//정수 입력 받기
		num = sc.nextInt();
		// 반복문 :  맞출때까지
		while (answer != n) {
		while(random != num) { // 정수와 정답을 비교하여 판별
			// num가 random보다 크면 Down!, 아니고 num가 random보다 작으면 up!, 아니면 Good!
		if (num > random) {
			System.out.println(" Down! ");
		}else if( num < random) {
			System.out.println(" UP! ");
		}else {
			System.out.println(" Good! ");
		}
	}
		
    sc.close();
    */
		
     int min = 1, max = 100;
     char menu;
     int num, random;
     Scanner sc = new Scanner(System.in);
     /* 외부 반복문 : 게임을 더 진행할건지 결정하는 반복문
     * 반복횟수 : 입력받은 문자가 n이 아니면 반복
     * 규칙성 : Up Down 게임 한 판 진행
     */
     do {
    	 
    	 // 랜덤한 수 생성
    	 random = (int)(Math.random()*(max - min +1)+ min);
     
    	/* 내부 반복문 : up down 게임 진행하는 반복문
    	 * 반복횟수 : 입력받은 숫자가 랜덤한 숫자와 일치하지 않으면 반복
    	 * 규칙성 : 입력받은 숫자가 정답보다 크면 Down, 작으면 Up, 맞으면 Good을 출력
    	 */
    	 do {
    		 // 입력을 받기
    		 System.out.println("input : ");
    		 num = sc.nextInt();
    		 
    		 //판별한 후 결과 출력
    		 if( num > random ) {
    			 System.out.println("Down!");
    		 }else if ( num < random ) {
    			 System.out.println("UP!");
    		 }else {
    			 System.out.println("Good!");
    		 }
    	 }while(random != num);
    	
    	// menu를 선택( 더 할 건지 말건지 )
    	 System.out.println(" countinue ( y/n ) : ");
    	 menu = sc.next().charAt(0);
    }while(menu != 'n');
       
     sc.close();
     }
}