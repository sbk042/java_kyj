package day4.IfEx;

public class NestedIfex {

	public static void main(String[] args) {
		/* 2,3,6위 배수 판별 예제
		 * (day4/pracrice패키지에 IFMultipleEX2 문제)
		 */
		
		int num = 5;
		
		//2의배수, 2,4,6,8,10,12
		if(num % 2 == 0) {
			//3의 배수 ==> 6의 배수 6,12,18
	        if(num % 3 == 0) {
	        	System.out.println(" A multiple of 6");
	        }
			//아닌 수 ==> 2의 배수 2,4,8,10
	        else {
	        	System.out.println(" A multiple of 2");
	        }
		}
		//3의배수
		else if(num % 3 ==0) {
			System.out.println(" A multiple of 3");
		}
	}
		//아닌 수
		else {
			System.out.println(" Not multiples of 2,3,6");
		}
		

	}

}
