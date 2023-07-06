package practice;

public class WhileEx {

	public static void main(String[] args) {
		//3의 배수의 합을 구하세요.
		//While문을 사용해서 1부터 1000가지의 자연수 중 3의 배수의 합을 구해보세요.
		
		int avg = 0;
		int num = 1;
		
		while(num<=1000) {
			if(num % 3 == 0) { //3으로 나누어 떨어지면 3의배수이다.
				avg = avg+num;
			}
			num = num+1;
		}
		System.out.println(avg);
	}

}
