package day6.ForEx;

public class HelloworldEx {

	public static void main(String[] args) {
		/* for문을 이용하여 Hello world를 5번 출력하는 예제
		 * 반복 횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : Hello world를 출력
		 * */
		//정수 선언
		int i;
		for(i =1 ; i <= 5 ; i++ ) {
			System.out.println("Hello world");
		}
		System.out.println("=============================");
		// while문으로는?
		// i를 일단 초기화 하기
		i = 1;
		while(i <= 5) { // i는 5까지
			System.out.println("Hello world");
			i++; // i는 1씩 증가
		}

	}

}
