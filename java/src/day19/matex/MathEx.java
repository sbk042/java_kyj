package day19.matex;

public class MathEx {

	public static void main(String[] args) {
		
		System.out.println(Math.abs(-1.2));//-1.2의 절대값
		System.out.println(Math.ceil(1.29));//1.29의 소수점 첫번째 자리에서 올림
		System.out.println(Math.floor(1.29));//1.29의 소수점 첫번째 자리에서 내림
		System.out.println(Math.round(1.29));//1.29의 소수점 첫번재 자리에서 반올림
		System.out.println(Math.pow(2, 3));//2의 3제곱을 의미한다.
		System.out.println(Math.random());//0이상 1미만의 난수를 의미한다.
		
		//기본 제공은 첫번째 자리에서 반올림이지만 응용해서 만들 수 있다.
		//1.29의 소수점 둘째자리에서 반올림을 하고 싶다
		double num = 1.29;
		int pos = 2; //소수점 pos자리에서 반올림하는 뜻을 가지고 있다.
		num *= Math.pow(10, pos-1); //기존 num에 10을 곱해주면 12.9가 된다
		num = Math.round(num); //12.9를 소수점 첫번째 자리에서 반올림
		num /= Math.pow(10, pos-1);
		System.out.println(num); //1.29를 소수점 두번재 자리에서 반올림
	}

}
