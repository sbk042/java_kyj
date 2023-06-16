package day12.homework;

import java.util.Scanner;

import array.Array;

public class LottoEx {

	public static void main(String[] args) {
		/* 로또 번호를 생성하고, 사용자가 번호를 입력하면 몇등인지 출력하는 코드를 작성하세요.
		 * 
		 * 1등 : 번호 6개
		 * 2등 : 번호 5개 + 보너스
		 * 3등 : 번호 5개
		 * 4등 : 번호 4개
		 * 5등 : 번호 3개
		 * 
		 * number : [1, 3, 40, 23, 24, 45]
		 * bonus : 2
		 * user : 1 2 3 4 5 6 
		 * losing ticket!
		 */
		
		
		int min = 1, max = 45; // 로또 랜덤 수 최소값 최대값 지정
		
		
		// 1.) 랜덤으로 로또번호 6개와 보너스 번호1개를 생성 (중복x)
		// 7개짜리 배열에 로또번호를 생성하고 , 앞에 6개는 로또번호로 지정, 마지막 1개는 보너스번호로 활용.
		int lotto[] = new int[7]; // 로또를 랜덤으로 받을 저장소 7개를 생성
		// 7개짜리 배열에 로또번호를 생성
		Array.createRandomArray(1, 45, lotto);
		
		// 마지막 1개는 보너스로
		int bonus = lotto[6];
		int lotto2[] = new int[6];
		// 앞에 6개는 로또번호
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		// 로또 번호 정렬
		Array.sort(lotto2);
		
		System.out.print("number : ");
		Array.printArray(lotto2);
		System.out.println("bonus " + bonus);
		
		// 2.) 사용자가 번호를 6개 입력
		Scanner sc = new Scanner(System.in); //입력받을 스캐너 생성
		int user[] = new int[6]; //내가 입력할 번호 저장소 6개 생성
		
		System.out.println("user : "); //안내 문구 출력
		for(int i = 0 ; i<user.length; i++) { 
			user[i] = sc.nextInt();
		}
		// 3.) 중복입력하면 판별을 하지 않음.
		if(Array.arrayCheck(user)) {
			System.out.println("Wrong number!");
			return;
		}
		// 4.) 등수 판별
		int count = count(lotto2,user);
		printResult(count, Array.contains(user, bonus, user.length));
		
		sc.close();
	}
	
	/**  로또 번호와 사용자 번호가 주어지면 몇개가 같은지 알려주는 메서드
	 *  매개변수 : 로또 번호, 사용자 번호 = > int lotto[], int user[]
	 *  리턴타입 : 몇개 같은지 => 정수 => int
	 *  메서드명 : count
	 */
	public static int count(int lotto[], int user[]) {
		
		if(lotto == null || user ==null) { //로또번호와 내가 입력한 수가 같은게 하나도 없으면
			return 0; // 0으로 빠져나간다.
		}
		
		int count = 0;
		for( int tmp : lotto) {
			if(Array.contains(user, tmp, user.length)) {
				count++;
			}
		}
		return count;
	}
	/** 일치하는 개수와 보너스번호와 사용자 번호가 일치하는 여부를 알려주면
	 *  등수를 출력하는 메서드
	 *  매개변수 : 일치하는 개수, 보너스 번호와 일치여부
	 *  		 => int count, boolean checkBonus
	 *  리턴타입 : 없음 => void
	 *  메서드명 : printResult
	 */
	public static void printResult( int count, boolean checkBonus) {
		switch(count) {
		case 6 :
			System.out.println(" Winner of the lottery!");
			break;
		case 5 :
			if(checkBonus) {
				System.out.println(" Second place in the lottery");
			}else {
				System.out.println(" 3rd place in the lottery");				
			}
			break;
		case 4 :
			System.out.println(" 4th place in the lottery");
			break;
		case 3 :
			System.out.println(" 5th place in the lottery");
			break;
		default:
			System.out.println("Losing ticket!");
		}
	}
}
