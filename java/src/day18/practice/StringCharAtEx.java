package day18.practice;

import java.util.Scanner;

public class StringCharAtEx {

	public static void main(String[] args) {
		/* 영문 소문자로 된 문자열을 입력받아 알파벳이 각각 몇개 있는지 확인하는 코드를 작성하세요.
		 * 
		 * input : hello world
		 * d : 1
		 * e : 1
		 * h : 1
		 * l : 3
		 * o : 2
		 * r : 1
		 * w : 1
		 * 0개인 애들은 출력하지 않는다.
		 */
		
		int alphabet[] = new int[26]; //각 알파벳 개수를 저장하는 배열. 0번지 : a의 개수, 1번지 : b의 개수.
		
		Scanner sc = new Scanner(System.in);//입력받을 스캐너 생성
		System.out.println("input : "); //안내문구 출력
		String str = sc.nextLine(); //문장으로 입력받으니 nextLine으로 출력
		
		
		//반복 : 문자열 길이만큼 반복한다.
		for(int i = 0; i < str.length(); i++) {
			//문자열의 한글자씩 가져와서 알파벳을 확인하여 알파벳 개수를 증가한다. (해당하는 알파벳이 몇개인지 개수 증가)
			char ch = str.charAt(i); //입력받은 str에서 i번째있는 문자를 가져온다.
			
			//ch가 알파벳 소문자인 경우 0~25사이의 값이 나온다.
			int distance = ch - 'a'; //ch에서 a를 빼준다.
			
			//영문 소문자가 아닌 경우
			if( distance < 0 || distance > 25 ) {
				continue; // =>건너 뛴다.
			}
			//맞는 경우
			alphabet[distance]++; 
		}
		//알파벳 개수 추가를 해준다.
		for(int i = 0; i < alphabet.length; i++) {
			
			if(alphabet[i] == 0) { //알파벳 i번재 오는 자리가 0개이면
				continue; //=> 건너뛴다.
			}
			System.out.println((char)('a' + i ) + " : " + alphabet[i]);
		}
		sc.close();
	}
}
