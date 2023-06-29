package day22.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import day20.practice.student.vo.Student;

public class FunctionalInterfaceEx2 {

	public static void main(String[] args) {
		//Supplier 인터페이스
		Supplier<String> supplier = ()-> "Hi"; //매개변수는 없고 리턴타입은 있는 거임
		System.out.println(supplier.get());
		
		//Function 인터페이스
		Function<Student,String/*매개변수, 리턴타입|학생정보가 주어지면  문자열로 받겠다*/> function = std->std.getName();
		System.out.println(function.apply(new Student(1,1,1,"Hong")));
		
		//Operator 인터페이스
		UnaryOperator<Student> operator = std-> {
			std.setGrade(2);
			return std;
		};
		System.out.println(operator.apply(new Student(1,1,1,"Hong")));
		
		//Predicate 인터페이스 (리턴값이 true false로 나타낸다)
		Predicate<Student> predicate = s -> s.getName().indexOf("Hong") == 0;//시작하는 단어가 Hong인지 확인
		System.out.println(predicate.test(new Student(1,1,1,"Hong")));//맞으면 true 틀리면 false로 출력
	}
}





