package day11.practice;

public class ArrayRandomEx {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 3개 만들어서 배열에 저장한 후 출력하는 코드를 작성하세요. 
		 * */
	
		int min = 1, max = 9; //랜덤생성 최솟값과 최댓값 입력
		int [] arr = new int[3]; //배열선언 정수3개의 저장소를 만들겠다.
		/*
		 * int random1 =(int) (Math.random() * (max - min +1) + min);
		   int random2 =(int) (Math.random() * (max - min +1) + min);
		   int random3 =(int) (Math.random() * (max - min +1) + min);
		 */
		/*
		arr[0] = (int) (Math.random() * (max - min +1) + min);
		arr[1] = (int) (Math.random() * (max - min +1) + min);
		arr[2] = (int) (Math.random() * (max - min +1) + min);
		*/
		for(int i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random() * (max - min +1) + min);//랜덤 생성
			System.out.println(arr[i]); //배열 출력
		}
		
		/*
		System.out.println(arr[0]));
		System.out.println(arr[0]));
		System.out.println(arr[0]));
		*/
	}

}
