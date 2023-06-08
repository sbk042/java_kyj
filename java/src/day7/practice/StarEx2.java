package day7.practice;

public class StarEx2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * *           i = 1 *= 1
		 * **          i = 2 *= 2
		 * ***         i = 3 *= 3
		 * ****        i = 4 *= 4
		 * *****       i = 5 *= 5
		 *             따라서 *= i
		 */
		
		/* 외부 반복문
		 * 반복 횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : * 5개를 출력 후 엔터
		 * */
		
		for( int i = 1 ; i <= 5 ; i++ ) {
		  /* * 5개를 출력
		   * 내부 반복문
		   * 반복횟수 : j는 1부터 i까지 1씩 증가
		   * 규칙성 : *을 출력
		   * 출력 후 엔터
		   */
			 for( int j = 1 ; j <= i ; j++ ) {
				 System.out.print('*');
			 }
		System.out.println();

	}

	}
}
