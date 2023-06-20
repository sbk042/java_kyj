package day15.quiz;

public class Ex2 {

	public static void main(String[] args) {
		/* 1부터 10까지 짝수를 출력하려고 한다. 다음 빈칸에 알맞은 코드를 
		 * 작성하세요. 빈 칸 이외의 코드는 수정하지 말 것.
		 * __는 두 칸을 의미하는게 아님. 빈칸을 의미
		 * 
		 * for(int i =2; i __ 10; __){
		 *     System.out.println(__);
		 *     }
		 */
		
		for(int i = 2; i<= 10; i+=2) { //i는 2씩 증가
			System.out.println(i);
		}

	}

}
