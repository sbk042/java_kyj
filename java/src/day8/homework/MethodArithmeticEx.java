package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 단, 메서드 이용
		 * 연산자를 잘못 입력한 경우는 없다고 가정한다.
		 * 0으로 나누는 일은 없다고 가정.
		 */
		
		//메인에서 테스트 해보기 제일 마지막으로 작성함
		Scanner sc = new Scanner(System.in);
		int num1, num2; //정수 두 개 입력받기
		char operator; // 산술 연산자 입력받기 (문자로 입력받기)
		double res;
		
		System.out.println("input (ex : 1 + 2) : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		//첫번째 식 출력
		res = arithmetic(num1, operator, num2);
		
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
		
		//두번재 식 출력
		res = arithmetic2(num1, operator, num2);
		
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
		
		sc.close();

	}
	
	/** 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메서드
	 * 매개변수 : 두 정수와 산술 연산자 => int num1, char operator, int num2  순서는 내가 정하기 나름
	 * 리턴타입 : 산술 연산 결과 => 실수 => double (나누기 때문에 실수로 나와야됨 )
	 * 메서드명 : arithmetic
	 */
	public static double arithmetic(int num1, char operator, int num2) {
		double res = 0.0; //초기값을 0.0으로 설정 
		switch(operator) {
		case '+' :
			res = num1 + num2;
			break;
		case '-' : 
			res = num1 - num2;
			break;
		case '*' :
			res = num1 * num2;
			break;
		case '/' :
			res = num1 / (double)num2;
			break;
		case '%' :
			res = num1 % num2;
			break;
		/*default:
		 *        잘못된 연산자인 경우 예외처리를 해야 하는데 아직 안 배워서 주석처리
		 *        throw new RuntimeException("Wrong operator!");
		 */
		}
		return res;
	}
	public static double arithmetic2 (int num1, char operator, int num2) {
		double res = 0.0; //초기값을 0.0으로 설정 
		switch(operator) { //스와치문에 케이스 안에 리턴문이 들어가는 경우 break문이 필요 없다.
		case '+' :
			return  num1 + num2;
			//break; //위에 return이 있기 때문에 break가 실행도리 일이 절대 없음 => 에러발생
		case '-' : 
			return  num1 - num2;
		case '*' :
			return  num1 * num2;
		case '/' :
			return  num1 / (double)num2;
		case '%' :
			return  num1 % num2;
		default:
		/*        잘못된 연산자인 경우 예외처리를 해야 하는데 아직 안 배워서 주석처리
		 *        throw new RuntimeException("Wrong operator!");
		 */
			return 0.0;//여기 있어도 되고 default값 밖에서도 써도 됨
		}
		
	}

}
