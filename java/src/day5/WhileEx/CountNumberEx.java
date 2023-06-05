package day5.WhileEx;

public class CountNumberEx {

	public static void main(String[] args) {
		/* 1부턴 10까지 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 i가 10까지 1씩 증가 
		 * 규칙성 : i를 출력
		 */
		int i = 1; // i는 1부터
		while( i <= 10) { // i는 10까지
			System.out.println(i);
			++i; // i는 1씩 증가
		}
		/* 초기화;
		 * while(조건식){
		 *           실행문;
		 *           증감식;// 없을 수도 있음. 실제로는 실행문.
		 */

	}

}
