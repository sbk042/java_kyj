package day8.Practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하세요.
		 * 단, 메서드를 이용할 것.
		 */
		
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.println(" input a number : ");
		num1 = sc.nextInt();
		 if(ismultiple(num1,6)) {
			 System.out.println(num1 + "is a multiple of 6.");
		 }else if (ismultiple(num1, 2)){
			 System.out.println(num1 + "is a multiple of 2.");
		 }else if (ismultiple(num1, 3)) {
			 System.out.println(num1 + "is a multiple of 3.");
		 }else {
			 System.out.println(num1 + "is not a multiple of 2,3,6");
		 }
		 sc.close();
		
		
	}
		/** num가 주어지면 2,3,6의 배수인지 아닌지 알려주는 메서드
		 * 매개변수 : 두 정수 => int num1, int num2
		 * 리턴타입 : 배수인지(참) 아닌지(거짓) = > boolean
		 * 메서드명 : ismultiple
		 */
		public static boolean ismultiple(int num1, int num2) {
			return num1 % num2 == 0;
		}

	}


