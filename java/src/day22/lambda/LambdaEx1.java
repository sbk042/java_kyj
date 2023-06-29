package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		//InterfaceA a = new InterfaceA(); 인터페이스 자체만으로 객체를 만들 수 없다.
		InterfaceA a = new InterfaceA() {
			
			@Override
			public int getMax(int num1, int num2) {
				return num1 >= num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		
		InterfaceA b = (num1, num2)->{
			return num1 >= num2 ? num1 : num2; //구현
		};
		System.out.println(b.getMax(10, 20));
		
		//람다식 생략하기
		InterfaceA c = (num1, num2)->num1 >= num2 ? num1 : num2; //구현
		System.out.println(b.getMax(10, 20));
	}  

}
//인터페이스 생성
interface InterfaceA{
	int getMax(int num1, int num2);
	
}