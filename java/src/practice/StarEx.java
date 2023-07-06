package practice;

public class StarEx {

	public static void main(String[] args) {
		//while문 또는 for문을 사용하여 다음과 같이 별*을 표시하는 프로그램을 작성해보자
		int i = 0;
		while(true) {
			i+=1;
			if(i>5) {
				break;
			}
			for(int j = 0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}