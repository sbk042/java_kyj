package day15.quiz;

public class Ex5 {

	public static void main(String[] args) {
		/* 다음 코드에서 잘못된 내용을 수정하세요.
		 * 0번부터 차례대로 0,1,2,3..을 저장하는 코드
		 * 
		 * int arr[] = new int[10];
		 * for(int i = 1; i <= arr.length; i+){
		 * 	   arr[i] = i;
		 * }
		 */
		
		// i = 0부터 i < 작아야 된다.
		int arr[] = new int[10];
		int i = 0;
		for(i = 0; i<arr.length; i++) {
			arr[i] = i;
		}
		System.out.println(arr[i]);
		System.out.println(i);

	}

}
