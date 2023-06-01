package day3.practice;

public class Ex3_If {

	public static void main(String[] args) {
		/* 정수 num을 입력받아서 num이 0인지, 음수인지, 양수인지를 판별하는 코드를
		 * if문을 이용하여 작성하세요.
		 */
		// num이 0이면 0이라고 출력하고
		// num이 음수이면 음수라고 출력하고
		// num이 양수이면 양수라고 출력하는 코드를 작성하세요.
		
		// 먼저 num을 지정 (숫자에 따라 결과가 달라짐 )
		int num = 0;
		// num이 0이면 0이라고 출력하는 조건문
		if (num == 0) {
			System.out.println("num은 0 입니다.");
		}
		// num이 양수이면 양수라고 출력하는 조건문
		if (num > 0) {
			System.out.println("num은 양수 입니다.");
		}
        // num이 음수이면 음수라고 출력하는 조건문
		if (num < 0) {
			System.out.println("num은 음수 입니다.");
		}
	}

}
