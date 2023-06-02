package day4.practice;

import java.util.Scanner;

public class IfScoreEx {

	public static void main(String[] args) {
		/*  90이상 ~ 100이하 : A
		 *  80이상 ~ 90미만 : B
		 *  70이상 ~ 80미만 : C
		 *  60이상 ~ 70미만 : D
		 *  60미만 : F
		 *  0보다 작거나 100보다 큰 경우 : Wrong score
		 */
		
		int num;
		System.out.println(" Input your score : ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		if(num >= 90 && num <= 100) {
			System.out.println('A');
		}
		else if(num >= 80 && num < 90 ) {
			System.out.println('B');
		}
		else if(num >= 70 && num < 80 ) {
			System.out.println('C');
		}
		else if(num >= 60 && num < 70 ) {
			System.out.println('D');
		}
		else if(num < 60 && num >= 0 ) {
			System.out.println('F');
		}
		else {
			System.out.println("Wrong Score");
		}
		sc.close();
		

	}

}
