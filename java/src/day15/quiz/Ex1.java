package day15.quiz;

public class Ex1 {

	public static void main(String[] args) {
		/* Hello를 10번 출력하려 한다. 아래 코드에서 잘못된 부분을 찾아 수정하세요.
		 * 
		 * for(int i = 0; i<10; i++);{
		 * 		System.out.println("Hello");
		 * }
		 */
		 // ;를 제거
		// for반복문()옆에 세미클론이 붙어 있는게 잘못된 부분이다.
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello");
		}

	}

}
