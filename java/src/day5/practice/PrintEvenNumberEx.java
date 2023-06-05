package day5.practice;

public class PrintEvenNumberEx {

	public static void main(String[] args) {
		// 10이하의 짝수를 출력하는 코드를 작성하세요.
		/* 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * 
		 * 방법1.
		 *  반복횟수 : i는 1부터 5까지 1씩 증가
		 *  규칙성 : 2*i를 출력
		 * 
		 * 방법2.
		 *  반복횟수 : i는 2부터 10까지 2씩 증가
		 *  규칙성 : i를 출력
		 *  
		 * 방법3.
		 *  반복횟수 : i는 1부터 10까지 1식 증가
		 *  규칙성 : i가 짝수이면 i를 출력
		 */
		
		// 방법1.
		int i = 1; // i가 1부터
		while( i <= 5 ) { // i가 5까지
			System.out.println(2*i);
			++i; // i는 1씩 증가
		}
		System.out.println("==================");
		//방법2.
		i = 2; // i가 2부터
		while( i <= 10 ) { // i가 10까지
		    System.out.println(i);
		    i = i + 2; // i += 2;
		}
		System.out.println("==================");
		//방법3.
		i = 1;
		while(i <= 10) {
			//i가 짝수이면 i를 출력
			if(i % 2 == 0) {
				System.out.println(i);
			}
			++i;
			
		}
	}

}
