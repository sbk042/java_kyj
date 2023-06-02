package day4.practice;

import java.util.Scanner;

public class IfSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12,1,2, : 겨울
		 * 월이 3이거나 4이거나 5이면 봄이라고 출력하고
		 * 월이 6이거나 7이거나 8이면 여름이라고 출력하고
		 * 월이 9이거나 10이거나 11이면 가을이라고 출력하고
		 * 월이 12이거나 1이거나 2이면 겨울이라고 출력
		 * 아니면 잘못된 월이라고 출력
		 */
		
		int month;
		System.out.println(" Input Month : ");
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		
		// 월이 3이상이고 5이하이면
		 if(month >= 3 && month <= 5) {
		    System.out.println("Spring");
		}
		 //월이 6이상이고 8이하이면
		else if(month >= 6 && month <= 8) {
			System.out.println("Summer");
		}
		 //월이 9이상이고 11이하이면
		else if(month >= 9 && month<=11 ) {
			System.out.println("Autumn");
		}
		 //월이 12이거나 월이 1이상이고 2이하이면
		 // 부호가 다른 연산자가 섞여 있는 경우에는 '()'를 넣어 구분해 줘야 한다. 
		else if(month == 12 || (month >= 1 && month <= 2)){
			System.out.println("Winter");
		}
		else {
			System.out.println("Wrong month");
		}
		
		  // 월이 3또는 4또 는5
		if(month == 3 || month == 4 || month == 5) {
		    System.out.println("Spring");
		}
		 //월이 6또는 7또는 8
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("Summer");
		}
		 //월이 9또는 10또는 11
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("Autumn");
		}
		 //월이 1또는 2또는 12
		else if(month == 1 || month == 2 || month == 12){
			System.out.println("Winter");
		}
		else {
			System.out.println("Wrong month");
		}
		sc.close();
		
		
		//boolean Spring = (season>2)&&(season<6);
		//System.out.println(Spring);
	}

}
