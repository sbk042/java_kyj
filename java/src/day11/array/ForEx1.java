package day11.array;

public class ForEx1 {

	public static void main(String[] args) {
		int arr[] = new int[] {4,5,2,1,9};
		
		for(int i = 0; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.println(tmp);
		}
		System.out.println("===========");
		for(int tmp : arr) { //향상된 for문으로 작성
			System.out.println(tmp);
		}
		//위 와 아래 코드는 같다 하지만 아래 있는 코드가 더 간결하게 보임
		arr = new int[] {4,5,2,1,9}
		for(int tmp : arr) {
			tmp = 0;
			System.out.println(tmp);
		}
		System.out.println("===========");
		for(int tmp : arr) { //향상된 for문으로 작성
			System.out.println(tmp);
		}

	}

}
