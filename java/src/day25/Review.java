package day25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Review {

	public static void main(String[] args) {
		
		//문제 1.
		ArrayList<Point>list = new ArrayList<>();
		list.add(new Point(1,2));
		//정수형 변수 x,y가 선언되지 않음
		//int x = 1, y = 2;
		list.add(new Point(x,y));
		list.add((3,4)); //new Point가 빠졌음

	}

}
//문제2.
public class Point{
	int x,y;
	public Point(int x, int y){//this : 주로 생성자나 메서드에서 멤버변수와 매개변수를 구분할 때 사용한다.
		/*this.*/x = x; //this가 빠졌음
		/*this.*/y = y;
	}
}
//문제 3.
public class Test1{

	public static void main(String[] args){
		//List 인터페이스는 List 인터페이스를 구현한 구현 클래스 ArrayList의 객체를 관리할 수 있다.
		//List는 제네릭 클래스이다. 멤버의 타입이 정해지지 않고 객체를 생성할 때 정해지는 클래스이다.
		//제네릭 클래스는 <>에 클래스명이 들어가야함. 기본 자료형X => 레퍼 클래스를 이용
		List<int/*Integer*/> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		 
//문제 4.
public class Test3 {

	public static void main(String[] args) {
		//HashSet은 List의 구현 클래스가 아니기 때문에 HashSet의 객체를 List가 관리할 수 없다.
		List<Integer> list = new HashSet/*ArrayList*/<>();
		//3은 int3이 자동으로 박싱되서 Integer의 객체로 저장
		list.add(3);
		list.add((int)4);//4자체가 int이기 때문에 의미가 없는 int 이다.
		//5를 박싱으로 Integer의 객체로 변환 후 저장
		list.add((Integer)5);
		// 3,4는 자동으로 박싱 되고, Integer를 붙여 직접 박싱을 한다.
		// 3가지 모두 다 사용할 수 있음 
	}
}
//문제 5.
public class Test4 {

	public static void main(String[] args) {
		//num가 짝수인지 홀수인지 판별하는 예제
		int num = 3;
		//괄호가 없다.
		if(num % 2 == 0)/*{*/
			System.out.println("짝수");
		//else옆에 ;때문에 else문의 실행문이 없음. 홀수는 num값과 상관없이 출력
		//;을 제거
		/*}*/else;//세미콜론을 지워야 한다.
			System.out.println("홀수");
	}

}
//문제 6.
public class Test5 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		//add,size는 Collection 인터페이스에 있는 메서드이다
		//Collection 인터페이스의 자식으로 List와 Set이 있다.
		set.add(1);
		set.add(2);
		/*for(Intget tmp : set){
		 * 		System.out.println(tmp);
		 * }*/
		for(int i = 0; i<set.size(); i++) {
			//get은 List에 있는 메서드이다. Set에는 없는 메서드이다.
			System.out.println(set.get(i));
		}
	}
}
//문제 7.
public class Test6 {

	public static void main(String[] args) {
		//평균 예제
		int kor = 100, eng = 90, math = 34;
		//실수를 정수형 변수에 저장하려고 했기 때문에 에러가 발생.(자동으로 형변환X)
		//3,0으로 나누는거기 때문에 형변환을 해줘야한다.
		//int를 => double로 고쳐야함
		int/*double로 변경*/ avg = (kor + eng + math)/3.0;
		System.out.println("평균 : " + avg);
	}
}
//문제 8.
public class Test7 {

	public static void main(String[] args) {
		
		System.out.println(sum(10,20));
		System.out.println(sum(10.4,12.2));
	}
	//메서드 오버로딩 : 메소드명이 같고, 매개변수가 다를 때(리턴타입은 상관없음)
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	//이미 sum(정수,정수)가 있기 때문에 아래 메서드는 오버로딩이 될 수 없다.
	public static double sum(int/*int지우고 double*/ num1, int/*int지우고double*/ num2) {//double num1, double num2라고 고쳐야됨
		return num1 + num2;
	}
}
//문제 9.
public class Test8 {

	public static void main(String[] args) {
		int num = 3;
		System.out.println(num + "는 짝수인가? " + isEven(num));
	}
	
	//홀짝을 판별하는 메서드
	//메서드는 리턴타입이 있으면 어떤 상황에서도 반드시 해당 타입으로 리턴을 해줘야 한다.
	//아래 코드는 홀수일 때 리턴을 안함 => 에러가 발생
	public static boolean isEven(int num) {
		if(num % 2 == 0) { 
			return true;
		}
		/*return false;*/ //홀수 일때 리턴타입이 없으므로 아무것도 반환되는게 없으니 이렇게 작성해주어야한다.
	}
}
//문제 10.
public class Test9 {

	public static void main(String[] args) {
		//0부터 차례대로 저장하는 예제
		//배열을 생성하지 않아서 저장할 수 없다.
		int [] arr; //int [] arr = new int[10]; 배열을 생성
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
}
//문제 11.
public class Test10 {

	public static void main(String[] args) {
		PhoneNumber pn1 = new PhoneNumber("Hong", null);
		//기본생성자가 없어서 에러가 발생한다.생성자가 있기 때문에 기본 생성자가 자동으로 추가되지 않는다.
		PhoneNumber pn2 = new PhoneNumber(/*여기에 변수를 넣거나*/);
	}

}

class PhoneNumber{
	private String name, number;
	
	/*public PhoneNumber()<>; 기본 생성자를 만들어주거나 위에 매개 변수를 넣거나 둘 중 하나*/
	
	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = number;
	}
	//toString메서는 Object 클래스에서 상속을 받는다.
	/*public String toString(){
	 * 			return xxx;
	 * }
	 * */
	@Override//이것을 제거해주거나 (메서드 오버로딩이 되기 때문에)
	//오버라이드를 하려면 메서드 선언부가 같아야 한다. 리턴타입 메서드명 매개변수가 같아야 한다.
	public String toString(/*String str 또는 오버라이드를 사용할 거면 매개변수를 지워 버린다.*/) {
		str = "이름 : " + name + ",번호 : " + number;
		return str;
	}
}
//문제 12
public class Test11 {

	public static void main(String[] args) {
		TestProgram tp = new TestProgram();
		tp.print();
	}

}
interface Program{
	void run();
}
class TestProgram implements Program{
		int num;
		
		void print() {
			System.out.println(num);
		}
	//Prpgram 인터페이스를 구현한 클래스이기 때문에 인터페이스에 있는 추상메서드를 반드시 오버라이딩 해야한다
	//  void run(){
		//}
	

	
}
	}
}