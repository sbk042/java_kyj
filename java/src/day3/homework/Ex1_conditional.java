package day3.homework;

import java.util.Scanner;

public class Ex1_conditional {

	public static void main(String[] args) {
		char gender;
		System.out.println(" Input gender : ");
		Scanner sc = new Scanner(System.in);
		gender = sc.next().charAt(0);
		boolean result = gender == 'W' ? true : false;
		System.out.println(" Are you a woman? " + result );
		sc.close();
				
	}

}
