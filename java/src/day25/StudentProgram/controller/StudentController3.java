package day25.StudentProgram.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.StudentProgram.vo.Student;

public class StudentController3 {

	//먼저 스캐너와 변수들을 선언한다.
	private Scanner sc = new Scanner(System.in);
	private List<Student> list = new ArrayList<Student>();
	
	public void run() {
		
		int menu;
		String fileName = "src/day25/student/student.txt";
		load(fileName); //로드는 반복문이 시작하기 전에 불러와야한다. (그렇지 않으면 반복문이 반복 될 때 마다 로드)
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택(메뉴를 입력받음) : Scanner 필요
			menu = sc.nextInt();
			//선택된 메뉴에 따른 기능을 실행
			runMenu(menu);
			
		}while(menu != 3);
		save(fileName);//반복문 끝난 다음에 저장한다.
		sc.close();
	}
	private void save(String fileName) {
		//학생정보를 저장 => 리스트 => 하나씩 꺼내서 저장한다.
		//저장을 하려면 => OutputStream을 사용한다. (코드에서 파일로 변경)
		//객체 단위로 저장해야 한다. => ObjectOutputStream을 이용											
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
		for(Student tmp : list) { //list에서 하나 꺼내와서
			oos.writeObject(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void load(String fileName) {
		try(ObjectInputStream ois
			=new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				Student tmp = (Student)ois.readObject();
				list.add(tmp);
			}
		}catch(FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		}catch(EOFException e) {
			System.out.println("불로오기 완료!");
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			//ObjectInpuStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable인터페이스를 구현하지 않으면 발생
			System.out.println("Student 클래스를 찾을 수 없습니다.");
		}
	}
	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생등록");
		System.out.println("2. 학생확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			//학생정보 입력
			insertStudent();
			break;
		case 2:
			//학생 전체를 확인
			print();
			break;
		case 3:
			break;
		default:
		}
	}
	
	public void insertStudent() {
		String num, name, major;
		Student tmp;
		//학번(문자열, 공백이 없는)
		System.out.print("학번 : ");
		num = sc.next();
		//이름(문자열, 공백이 있는)
		sc.nextLine();
		System.out.print("이름 : ");
		name = sc.nextLine();
		//과(문자열, 공백이 있는)
		System.out.print("전공 : ");
		major = sc.nextLine();
		//학생정보 리스트에 저장
		//입력한 정보를 이용하여 학생 객체를 생성
		tmp = new Student(num, name, major);
		//리스트에 학생 객체를 추가
		list.add(tmp);
	}
	
	public void print() {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}
}