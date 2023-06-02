package day3.homework;

import java.util.Scanner;

public class Ex1_conditional2 {

	public static void main(String[] args) {
		String gender;
		System.out.println(" Input gender : ");
		Scanner sc = new Scanner(System.in);
		gender = sc.next();
		boolean result = gender.equals("W") ? true : false;
		System.out.println(" Are you a woman? " + result );
		sc.close();
		
	}

}
