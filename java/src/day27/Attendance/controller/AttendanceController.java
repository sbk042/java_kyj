package day27.Attendance.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.library.vo.LoanBrowsing;
import day27.Attendance.vo.Attendance;
import day27.Attendance.vo.AttendanceBook;
import day27.Attendance.vo.Student;

public class AttendanceController implements Program{
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Student> stdList = new ArrayList<>(); //등록한 학생 정보를 저장 하기 위해 리스트 생성
	private AttendanceBook book = new AttendanceBook();
	
	
	public void run() {
		String fileName = "src/day27/attendance/attendancebook.txt";
		load(fileName); //로드는 반복문이 시작하기 전에 불러와야한다. (그렇지 않으면 반복문이 반복 될 때 마다 로드)
		int menu;
		do {
			System.out.println("================");
			//1.)메뉴 출력
			printMenu();
			//2.)메뉴 선택
			menu = sc.nextInt();
			//3.)선택된 메뉴에 따른 기능을 실행
			runMenu(menu);
			System.out.println("================");
		}while(menu != 4);
		save(fileName);
	}

	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. 학생등록"); //학생등록
		System.out.println("2. 출석체크"); //출석체크
		System.out.println("3. 출석확인"); //출석확인
		System.out.println("4. 프로그램 종료"); //프로그램 종료
		System.out.print("메뉴 선택 : "); //메뉴 선택
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insertStudent();
			break;
		case 2 : 
			attendanceCheck();
			break;
		case 3 : 
			printAttendance();
			break;
		case 4 : 
			System.out.println("EXIT!!!");
			break;
		default : System.out.println("Wrong number!");
		}
	}
	
	private void insertStudent() {
		//정보(학번, 이름) 입력
		System.out.println("학번 : ");
		String num = sc.next(); //학번은 공백없이 받기 때문에 next();로 받는다
		
		sc.nextLine(); //이전에 nextLine으로 안 받았다면 nextLine쓸 때 써주기
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		//출석부에 새 학생을 추가
		//입력받은 정보를 이용하여 학생 객체를 생성
		Student std = new Student(num, name);
		
		//생성된 학생 객체를 추가
		boolean insertSuccess /*성공했는지*/ = book.insertStudent(std);
		//추가에 성공하면 성공했다고, 실패하면 실패했다고 출력
		System.out.println("=======================");
		if(insertSuccess) {
			System.out.println("학생 정보 추가 성공");
		}else {
			System.out.println("학생 정보 추가 실패!");
		}
		
		/*
		//학생 등록 할 정보 입력
		sc.nextLine();
		System.out.println("num : ");
		String num = sc.nextLine();
		System.out.println("name : ");
		String name = sc.nextLine();
		
		//입력한 정보를 학생리스트에 저장
		//저장하기 위해 입력받은 정보를 가지고 객체 생성
		Student student = new Student(num, name);
		
		//학생이름 중복 체크
		if(studentList.contains(student)) {
			System.out.println("이미 등록된 학생입니다. 확인해주세요.");
			return; //확인했으면 빠져나가기
		}
		//중복되지 않는다면 studentList에 추가해 준다.
		studentList.add(student);
		
		//잘 등록 되었는지 확인하기 위해 출력해보기(나중에 주석처리 해주기)
		System.out.println(studentList); */
	}
	
	private void attendanceCheck() {
		//날짜 입력
		System.out.println("날짜(yyyy-MM-dd) : " );
		String dateStr = sc.next();
		
		//날짜가 제대로 입력됐는지 체크
		//SimpleDateFormat을 이용한다.
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			date = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("날짜 형식이 아닙니다.");
			return;
		}
		//출석부에서 학생 정보들을 가져와서 저장을 해준다.
		//=>출석부(AttendanceBook)에 학생정보들을 가져오도록 추가 작업을 해야한다.
		List<Student> stdList = book.getStdList();
		
		//반복문
		for(Student tmp : stdList) {
			//학생정보를 출력
			System.out.print(tmp + " : ");
			//학생의 출결을 입력받는다(O or X)
			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');//언제까지? 모든학생이 입력을 할 때 까지
			//출석부에 체크
			
			//출석부에 체크
			//학생정보, 출결일 이용하여 출석 객체를 생성
			//나중에 학생 삭제 기능이 추가되도 기존 출석 기록은 삭제되면 안되기 때문에 복사 생성자를 이용
			Attendance attendance = new Attendance(date, new Student(tmp), state);
			//출석부에 출석 개체를 추가하도록 만들어준다.
			//AttendanceBook에 출석 객체가 주어지면 출석명단에 추가하는 작업을 해야한다.
			if(!book.insertAttendance(attendance)) {
				System.out.println("이미 등록된 출석입니다.");
			}else {
				System.out.println("출석체크를 했습니다.");
			}
		}
	}
	
	private void printAttendance() {//출석확인 기능
	//출석부에 있는 모든 출석 정보를 확인한다.
	book.printAttendance();
		
		
	/*
	List<AttendanceBook> abList = new ArrayList<AttendanceBook>();
	abList.add(book);
	System.out.println(abList);	
	*/
	}
	
	void load(String fileName) {
		try(ObjectInputStream ois
			=new ObjectInputStream(new FileInputStream(fileName))){
			book = (AttendanceBook)ois.readObject();
		}catch(FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		}catch(EOFException e) {
			System.out.println("불로오기 완료!");
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			//ObjectInpuStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable인터페이스를 구현하지 않으면 발생
			System.out.println("LoanBrowsing 클래스를 찾을 수 없습니다.");
		}
	}
	void save(String fileName) {
		//도서정보를 저장 => 리스트 => 하나씩 꺼내서 저장한다.
		//저장을 하려면 => OutputStream을 사용한다. (코드에서 파일로 변경)
		//객체 단위로 저장해야 한다. => ObjectOutputStream을 이용											
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(book);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
