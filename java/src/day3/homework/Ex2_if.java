package day3.homework;

import java.util.Scanner;

public class Ex2_if {

	public static void main(String[] args) {
		/* 성별(M :남성,W : 여성)을 입력받아 M이면 남성을, W이면 여성을 출력하는 코드를 작성하세요.
		 * if문 사용
		 * 
		 * Input gender :
		 * M
		 * Are you woman? man
		 * 
		 * Input gender :
		 * W
		 * Are you woman? woman
		 */
		
	char gender;
	Scanner sc = new Scanner(System.in);
	System.out.println(" Input gender : ");
	gender = sc.next().charAt(0);
	String result = "";
	if( gender == 'M') {
		//System.out.println(" Are you a woman? " + "man");
		result = "man";
	}
	if( gender == 'W' ) {
	   // System.out.println(" Are you a woman? " + "woman");
		result = "woman";
	}
	System.out.println(" Are you a woman? " +  result );	
	
    sc.close();
	
	}

}
