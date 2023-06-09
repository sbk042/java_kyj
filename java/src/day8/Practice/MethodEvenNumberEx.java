package day8.Practice;

import java.util.Scanner;

public class MethodEvenNumberEx {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 짝수인지 아닌지 판별하는 코드를 작성하세요.
		 * 단, 메서드를 이용할 것.
		 * */
	
		int num1;
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		System.out.println(" input a number : ");
	
		if(num1 % 2 == 0){
			System.out.println(" Even number.");
		}else {
			System.out.println("Odd number");
		}
		printEvenNumber(num1);
		
		if(mod(num1, 2 ) == 0) {
			if(num1 % 2 == 0){
				System.out.println(" Even number.");
			}else {
				System.out.println("Odd number");
			}
		
			if(isEvenNumber(num1)){
				System.out.println(" Even number.");
			}else {
				System.out.println("Odd number");
			}
			
			if(isMultiple(num1, 2)) {
				System.out.println("Even number");
			}else {
				System.out.println("Odd number");
			}
		}
		sc.close();
	}
	/** num가 주어지면 num가 짝수인지 홀수인지 출력하는 메서드
	 * @param num : 판별할 정수 (매개변수)
	 * @return 없음 void
	 * 메서드명 : PrintEvenNumber
	 */
	
	public static void printEvenNumber(int num) {
		if(num % 2 ==0) {
			System.out.println("Even number.");
		}else {
			System.out.println("Odd number.");
		}
	}
	/** num1과 num2가 주어지면 num1을 num2로 나누었을 때 나머지를
	 * 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 나누었을 때 나머지 = > 정수 => int
	 * 메서드명 : mod
	 */
	public static int mod(int num1, int num2) {
		return num1 % num2;	//리턴타입 메서드명 (매개변수들)
		
	}
	/** num가 주어지면 num가 짝수인지 홀수인지 알려주는 메서드
	 * 매개변수 : 판별할 정수 => int num 
	 * 리턴타입 : 짝수인지(참) 홀수인지(거짓) => boolean (참 거짓)
	 * 메서드명 : isEvenNumber
	 */
	public static boolean isEvenNumber(int num) {
		return num % 2 == 0;
	}
	/** num1과 num2가 주어지면 num1이 num2의 배수인지 아닌지 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 배수인지(참) 아닌지(거짓) => boolean
	 * 메서드명 : isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
