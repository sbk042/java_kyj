package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import day21.practice.updown.vo.RecordGame;

public class GameManager implements Program{

	//리터럴 3에 이름을 붙여서(EXIT) 명확하게 전달하기 위해.
	private static final int EXIT = 3;
	
	//다른 메서드에서 매번 객체를 생성하는게 번거로워서 private으로 맨 위에 써준 것
	private Scanner sc = new Scanner(System.in);
	
	//기록을 저장하는 리스트를 만든다.
	private ArrayList<RecordGame> list = new ArrayList<>();
	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. play");
		System.out.println("2. record");
		System.out.println("3. exit");
		System.out.println(" select : ");
	}

	@Override
	public void run() {
		System.out.println("Program Start!");
		
		int menu; //메뉴 정수로 선언
		do {
			//메뉴 출력
			printMenu();
			//메뉴 입력받기
			menu = sc.nextInt();
			//입력한 숫자에 대한 실행
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			//랜덤 게임 시작
			//기록 리스트에 저장
			playGame();
			break;
		case 2 :
			//
			recordGame();
			break;
		case 3 : //나가기
			break;
		default : //잘못된 번호를 선택시 출력
			System.out.println("Worng menu!");
		}
	}
	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
		
	}

	private void playGame() {
		int min = 1, max = 100;
		int num = min -1; // 1~100이 아닌 정수로 초기화 하면 됨. 최소값 -1을 해서 랜덤으로 나올 수 없는 수
		int random;
		// 랜덤한 수를 생성 ( 및 출력 )
		random = (int)(Math.random()*(max - min + 1)+ min);
		System.out.println(random); //테스트로 출력 나중에 주석처리
		int count = 0;
		// 반복문 : 맞출때까지 => 입력한 정수가 정답이 아니면 반복
		while(random != num) { // 정수와 정답을 비교하여 판별
			//안내문구 출력
			System.out.println(" Input(1~100) : ");
			// 정수 입력받기
			num = sc.nextInt();
	// num가 random보다 크면 Down!, 아니고 num가 random보다 작으면 up!, 아니면 Good!
			if (num > random) {
				System.out.println(" Down! ");
			}else if( num < random) {
				System.out.println(" UP! ");
			}else {
				System.out.println(" Good! ");
			}
			count++;
		}
		//기록하기 : 아이디(우리가 입력해야함), 플레이 횟수(게임을 할 때 마다 계산 해야됨)
		//아이디 입력
		System.out.println("Record Id : ");
		String id = sc.next();
		//어떻게 저장해서 관리할 건가?
		RecordGame rec = new RecordGame(id, count);
		list.add(rec); //리스트 추가
		//sort();
		list.sort(new Comparator<RecordGame>() {
			
			@Override
			public int compare(RecordGame o1, RecordGame o2) {
				return o1.getCount() - o2.getCount();
			}
		});
	}
	//리스트를 정렬하는 버블정렬
	private void sort() {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = 0; j<list.size()-1; j++) {
				if(list.get(j).getCount() > list.get(j+1).getCount()) {//레코드 게임 안에 있는 회수를
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}	
	}
}
