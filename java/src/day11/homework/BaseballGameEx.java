package day11.homework;

import java.util.Scanner;

import array.Array;

public class BaseballGameEx {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요.
		 * 1~9 사이의 중복되지 않은 세 수를 맞추는 게임.
		 * 규칙 : 
		 * B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 30 : 일치하는 숫자가 하나도 없음
		 * 
		 * 예:
		 * 랜덤 숫자 : 1 9 5
		 * 사용자 : 1 2 3
		 * 1S
		 * 사용자 : 4 5 6 
		 * 1B
		 * 사용자 : 1 2 9
		 * 1S1B
		 * 사용자 : 2 3 4
		 * 3E
		 * 사용자 1 9 5
		 * 3S
		 * Good!
		 */
		
		int com[] = new int[3]; //랜덤으로 생성 된 수를 저장할 배열 (컴퓨터가 랜덤으로 수를 뽑은거라서 com이라고 쓴거임)
		int user[] = new int[3]; // 사용자가 입력한 수를 저장할 배열 (내가 입력하는 거라서 user)
		int min = 1, max = 9; // 랜덤 수 최소값 최대값 지정
		int strike = 0; //스트라이크 개수 초기화
		int ball = 0; //볼의 개수 초기화
		Scanner sc = new Scanner(System.in); //입력받을 스캐너 생성
		
		// 1.) 맞춰야할 숫자 3개를 랜덤으로 생성(중복 X)
		Array.createRandomArray(min, max, com);// 랜덤 생성 했었던 class Array파일에서 가져다가 쓴거
		// Array.printArray(com); // 나중에 주석 처리 할 예정
		
		// 반복문
		do { // 2.) 사용자가 숫자 3개를 입력 받기 (맞추기 게임)
			System.out.println("user : "); // 안내문구 출력 사용자가 3개의 수 입력
			for(int i = 0; i<user.length; i++) {
				user[i] = sc.nextInt(); //입력받은 숫자를 user[i]에 저장
			}
			
			// 사용자 입력 체크(만약 사용자가 중복 되게 숫자를 입력했을 때)
			 if(Array.arrayCheck(user)) {
				 System.out.println("You must not enter the same number!");
				 continue;
			 }
			
			
			
			// 3.) 맞는지 판별
			// 스트라이크 개수 판별
			strike = strike(com,user);
			
			
			// 볼의 개수 판별
			ball = ball(com,user);
			
			// 스트라이크와 볼의 개수에 맞게 출력
			printResult(strike , ball);
			
		}while(strike < 3); // 스트라이크가 3미만 일때 까지 계속 반복한다.
		
		System.out.println("Good!");
		sc.close();
	}
	
	/** 스트라이크 개수를 판별하는 메서드
	 *    => 두 배열에서 같은 번지에 있는 값들이 몇 개 같은지 알려주는 메서드
	 *  매개변수 : 두 배열 => int arr1[], int arr2[]
	 *  리턴타입 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 *  메서드명 : strike
	 */
	public static int strike(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 하나라도 있으면 배교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		// 배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0; //스트라이크 개수
		for(int i = 0; i<size; i++) {
			//같은 번지에 있는 값들이 서로 같으면(스트라이크이면)
			if( arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	/** 볼 개수를 판별하는 메서드
	 *    => 두 배열에서 다른 번지에 있는 값들이 몇 개 같은지 알려주는 메서드
	 *  매개변수 : 두 배열 => int arr1[], int arr2[]
	 *  리턴타입 : 다른 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 *  메서드명 : strike
	 */
	public static int ball(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 하나라도 있으면 배교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0; //볼을 세는 변수 필요
		// 다른 번지를 비교해서 찾아도 되지만
		// 두 배열에서 같은 숫자의 개수에서 스트라이크 개수를 빼면 볼의 개수
		for(int tmp : arr1) {
			// 배열1(arr1)에서 꺼낸 값이 arr2에 있으면 개수를 증가시킨다.
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1,arr2);
		
		
	    //위에나 아래 식 중 골라서 쓰기
		// 이중 반복문을 이용해서 다른 번지를 비교하는 코드
		/*for(int i = 0; i<arr1.length; i++) { //정석으로 적은거
			for(int j = 0; j<arr2.length ; j++) {
				if( i == j ) {
					continue;
				}
				if(arr1[i] == arr2[i]) {
					count ++;
				}
			}
		}
		return count;
		*/
	}
	/** 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메서드
	 *  매개변수 : 스트라이크 개수, 볼의 개수 => int strike, int ball
	 *  리턴타입 : 없음 => void
	 *  매서드명 : printResult
	 */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if( ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("30");
		}
		System.out.println();
	}
	/** 주어진 배열에 중복된 값이 있는지 없는지 알려주는 메서드
	 *  매개변수 : 배열 = > int arr[]
	 *  리턴타입 : 중복여부
	 *  메서드명 : array
	 */
	
	
	
	
	
}
