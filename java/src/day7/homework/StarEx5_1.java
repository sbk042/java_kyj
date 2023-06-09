package day7.homework;

public class StarEx5_1 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 *     *       i = 1 공=3 *= 1      *=1
		 *    ***      i = 2 공=2 *= 2 		*=3
		 *   *****     i = 3 공=1 *= 3 		*=5
		 *  *******    i = 4 공=0 *= 4 		*=7
		 *                   공 = half-i    *=2*i-1
		 *   *****     i = 5 공=1 *= 3 		*=5
		 *    ***      i = 6 공=2 *= 2 		*=3
		 *     *       i = 7 공=3 *= 1 		*=1   
		 *     				 공 = i -half    *2*(num+1-i)-1 = 2*(num-i)+1              
		 */					 
		
		int num = 11;
		for(int i = 1; i<=num; i++ ) {
			int half = (num + 1) / 2;
			//4줄 => (num +1)/2
			if(i <= half) {
				for(int j = 1; j<=half-i; j++) {
					System.out.print(' ');
				}
				for(int j =1; j <= 2*i-1; j++) {
					System.out.print('*');
				}
				//엔터
				System.out.println();
			}
			else {
				for(int j = 1; j<=i-half ; j++ ) {
					System.out.print(' ');
				    }
				for(int  j = 1; j<=2*(num-i)+1 ; j++) {
							System.out.print('*');
					}
					
				
					//엔터
					System.out.println();
			}
		}

	}

}

