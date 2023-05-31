package day2.homework;

public class Ex2 {

	public static void main(String[] args) {
		//두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요.
		//단, 2번째 숫자는 0이 아님
		
		int num1 = 1; int num2 = 2;
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double) num1 / num2;
		int mod = num1 % num2;
				
				System.out.println("" + num1 + num2 + "");
				System.out.println("" + num1 + '+' + num2 + "=" + sum);
				System.out.println("" + num1 + '-' + num2 + "=" + sub);
				System.out.println("" + num1 + '*' + num2 + "=" + mul);
				System.out.println("" + num1 + '/' + num2 + "=" + div);
				System.out.println("" + num1 + '%' + num2 + "=" + mod);

	}

}
