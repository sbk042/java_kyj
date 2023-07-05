package day26.library.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import day26.library.vo.Book;
import day26.library.vo.LoanBrowsing;

public class LibraryController {
	/*도서관리 프로그램을 작성하세요.
	- 도서 등록
	- 대출
	- 반납
	- 종료
	1.) 도서 클래스 필요
	- 제목
	- 저자
	- isbn
	- 도서번호
	2.) 도서 대출 정보 클래스 필요
	- 도서(대출된 도서)
	- 대출일
	- //반납 예정일
	- 실제 반납일
	 */
	private Scanner sc = new Scanner(System.in);
	//도서 리스트
	private List<Book> bookList = new ArrayList();
	//대출 열람 리스트
	private List<LoanBrowsing> loanList = new ArrayList();

	public void run() {
		int menu;
		String bookfileName = "src/day26/library/book.txt";
		loadBook(bookfileName); //로드는 반복문이 시작하기 전에 불러와야한다. (그렇지 않으면 반복문이 반복 될 때 마다 로드)
		do {
			System.out.println("===========");
			//메뉴 출력
			printMenu();
			//메뉴 선택(메뉴를 입력받음) : Scanner 필요
			menu = sc.nextInt();
			//선택된 메뉴에 따른 기능을 실행
			runMenu(menu);
			System.out.println("============");
		}while(menu != 3);
		saveBook(bookfileName);//반복문 끝난 다음에 저장한다.
		sc.close();
	}

	private void saveBook(String fileName) {
		//도서정보를 저장 => 리스트 => 하나씩 꺼내서 저장한다.
		//저장을 하려면 => OutputStream을 사용한다. (코드에서 파일로 변경)
		//객체 단위로 저장해야 한다. => ObjectOutputStream을 이용											
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
		for(Book tmp : bookList) { //list에서 하나 꺼내와서
			oos.writeObject(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadBook(String fileName) {
		try(ObjectInputStream ois
			=new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				Book tmp = (Book)ois.readObject();
				bookList.add(tmp);
			}
		}catch(FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		}catch(EOFException e) {
			System.out.println("불로오기 완료!");
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			//ObjectInpuStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable인터페이스를 구현하지 않으면 발생
			System.out.println("Book 클래스를 찾을 수 없습니다.");
		}
		//잘 불러와지는지 확인하는 용도 (나중에 주석처리)
		//System.out.println(bookList);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			//도서 등록
			insertBook();
			break;
		case 2:
			//도서 대출
			loanBook();
			break;
		case 3:
			//도서 반납
			returnBook();
			break;
		case 4:
			//프로그램 종료
			System.out.println("EXIT!!!");
			break;
		default:
			//잘못된 메뉴 입력
			System.out.println("Wrong Menu!!!!");
		}
	}

	private void returnBook() { //도서 반납하기
		
		
	}

	private void loanBook() { //도서 대출받기
		
		//대출 가능한 도서만들을 조회
		Stream<Book> stream = bookList.stream();//리스트를 이용해서 스트림 생성
		//도서 리스트에서 하나 꺼내온 걸 b라고 하고 boolean은 is로
		bookList
			.stream()
			.filter(b->!b.isLoan()) //대출 가능한 도서만 추출하고
			.forEach(b->{ //추출한 도서를 출력해준다.
				System.out.println("=================");
				System.out.println(b);
				System.out.println("=================");
			});
		/*
		//Stream을 사용하지 않는다면 이렇게 사용해도 됨
		for(Book tmp : bookList) {
			if(!tmp.isLoan()) {
				System.out.println("================");
				System.out.println(tmp);
				System.out.println("=================");
			}
		}
		*/
		//도서 번호를 입력받기
		sc.nextLine(); // 이전에 입력한 엔터처리
		System.out.print("도서 번호 : ");
		String num = sc.nextLine();
		
		//대출을 신청한다.
		//도서 번호가 올바른지 확인해야한다.
		//1.)번호에 맞는 도서가 있는지 확인한다.
		//도서가 없으면 올바르지 않음
		//도서가 있으면 대출중인지 확인
		boolean possible 
			= bookList
				.stream()
				.filter(b->!b.isLoan()&&b.getNum().equals(num))
				.count() > 0;		
		//올바르지 않으면(없는 도서번호이거나, 대출중인 도서인 경우)
		//대출할 수 없다고 출력해준다.
		if(!possible) {
			System.out.println("대출할 수 없습니다.");
			return;
		}
		//오바르면 대출을 진행
		//도서 대출 객체를 생성해야한다.(도서, 대출일.대출기간 )필요
		int index = bookList.indexOf(new Book(num,null,null,null)); //도서번호만 같으면 되므로
		Date loanDate = new Date();
		LoanBrowsing lb 
			= new LoanBrowsing( bookList.get(index), loanDate, 14); //대출기간 14일로 지정
		//대출열람 리스트에 추가 위에 private List<LoanBrowsing> loanList = new ArrayList();
		loanList.add(lb);
		bookList.get(index).loanBook(); //도서에 대출했다고 수정해줘야함
		//대출일을 출력해준다(해당 날짜)
		System.out.println("대출일 : " + lb.getLoanDateStr());
		//반납예정일도 출력
		
	}

	private void insertBook() { //도서 등록하기
		sc.nextLine(); //이전에 입력한 엔터 처리
		//1.) 도서 정보 입력
		System.out.println("도서 번호 : ");
		String num = sc.nextLine();
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		System.out.println("도서 저자 : ");
		String author = sc.nextLine();
		System.out.println("ISBN : ");
		String isbn = sc.nextLine();
		
		//도서정보 리스트에 저장
		//2.)입력한 정보를 이용하여 도서 객체를 생성
		Book book = new Book(num, title, author, isbn);
		
		//3.) 도서 리스트에 도서 객체를 추가(위에 스캐너 아래에 booklist만듬)
		bookList.add(book);
		
		//잘 등록했는지 확인하기 위해 출력해보기(나중에 주석처리)
		System.out.println(bookList);
	}

	private void printMenu() {
		System.out.println("Menu");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 대출");
		System.out.println("3. 도서 반납");
		System.out.println("4. 프로그램 종료");
		System.out.println("Select Menu : ");
	}

}
			
