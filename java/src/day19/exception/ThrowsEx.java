package day19.exception;

public class ThrowsEx {

	public static void main(String[] args) {
		//테스트해보기
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1,3,5};
		
		
		try {
			arr = null; //예외발생
			printArray(arr);
			//res = mod1(num1,num2); mod1에 대한 테스트
			res = mod2(num1,num2);
			System.out.println(res);
		} catch (Exception e) {
			//System.out.println("Exception : / by zero");
			System.out.println(e/getMessage);
		}

	}
	//try-catch를 이용하여 예외를 직접 처리
	public static int mod1(int num1, int num2) {
		try{//직접 예외처리
			int res = num1 % num2;
			return res;
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			return 0;
		}
	}
	//throws를 이용하여 예외를 미룸
	public static int mod2(int num1, int num2) throws RuntimeException {//Exception이라는 예외가 발생할 수도 있습니다.
		return num1 % num2;
	}
	
	public static void printArray(int arr[]) throws Exception {
		if( arr == null) {
			throw new Exception("Araay is null");
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
	
	
	
	
}
