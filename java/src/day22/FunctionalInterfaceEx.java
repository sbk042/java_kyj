package day22;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionalInterfaceEx {

	public static void main(String[] args) {
		//람다식
		//Consumer<String> consumer = (s) -> {System.out.println(s);}; 정식대로 적은 것
		Consumer<String> consumer = s -> System.out.println(s);//생략해서 만든것
		consumer.accept("Hong");
		
		Consumer<Student> consumer2 = s -> System.out.println(s.getName());
		Student std = new Student(1, 1, 1, "Hong");
		consumer2.accept(std);
		
		//학생 정보 전체 출력
		printStudent(std);
		printStudent(std, (s ->System.out.println(s)));
		
		//학생 이름만 출력
		printStudentName(std);
		printStudent(std, s -> System.out.println(s.getName()));
	
		//학생의 학년 따로 반따로 이름 따로 출력 (람다식으로)
		printStudent(std, s->{
			System.out.println("grade : " + s.getGrade());
			System.out.println("class : " + s.getClassNum());
			System.out.println("number : " + s.getNum());
		});
		}
	//학생 정보를 전체적으로 출력
	public static void printStudent(Student std /*학생정보가 주어지면*/) { //학생정보를 출력하는 기능을 만들려고 한다.
		System.out.println(std);//출력
	}
	//학생 이름만 출력
	public static void printStudentName(Student std) {
		System.out.println(std.getName());//출력
	}
	//람다식 이용
	public static void printStudent(Student std, Consumer<Student> consumer) {
		consumer.accept(std);
	}
}
@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
}
