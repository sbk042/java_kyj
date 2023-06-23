package day18.practice;

import java.util.Scanner;

public class StringSplitEx {

	public static void main(String[] args) {
		/* 문장을 입력받아 단어의 개수를 출력하는 코드를 작성하세요.
		 * 
		 * input : Hi. My name is hong.
		 * word : 5
		 */
		Scanner sc = new Scanner(System.in); //입력받을 스캐너 생성
		System.out.println("input : "); //안내문구 출력
		String str = sc.nextLine(); //공백을 포함하기 위해 nextLine 받기
		
		//공백을 기준으로 단어를 배열에 저장
		String words[] = str.split(" ");
		
		System.out.println("Word : " + words.length);
		
		//입력받은 문장 str을 " "로 구분해한 총 길이
		//배열에 저장 하지 않아도 밑에 있는 식 입력시 결과 같음
		//System.out.println(str.split(" ").length);
		
		sc.close();
	}

}
