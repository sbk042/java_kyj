package day12.practice;

import lombok.Data;

/* 한 단어를 관리하는 클래스를 만들거다.
 *  - 단어
 *  - 단어의 뜻들
 * */
@Data //getter, setter, toString, equals를 추가 
public class Word{
	// 멤버 변수
	private String title; //단어를 의미하는 title
	private String meaning[]; //뜻들이니까 저장소 여러개라서 빈 칸
	private int meaningCount; // 뜻이 저장된 개수
	
	//생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5]; // 기본 5개 (최대 5개의 뜻을 저장 할 수 있게 만듬)
		this.meaning[0] = meaning;
		meaningCount++; //뜻이 추가 되게 때문에 증가
	}
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];
	}
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		for(int i = 0; i<w.meaningCount; i++) {
			this.meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	//메서드 (기능)
	/** 단어와 뜻을 출력하는 메서드
	 * 매개변수 : 없음 (남의 정보가 아니라 내가 가지고 있는 정보기 때문에 매개변수 필요없음)
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i<meaningCount; i++) {
				System.out.println(i + 1 + ". " + meaning[i]);
		}
	}
	//메서드 기능 2
	/** 뜻을 추가하는 메서드
	 * 매개변수 : 추가입력받을 뜻 => String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : addMeaning
	 */
	public void addMeaning(String meaning) {
		//뜻이 다 찼으면 다 찼다고 출력하고 종료
		if(meaningCount == this.meaning.length) {//5개이상은 저장 할 수 없음
			System.out.println("It's all filled"); //다 찼다고 안내문 출력
			return; // 종료
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
		
	}
	//메서드 기능3
	/** 뜻을 제거하는 메서도(잘못 입력했을 때)
	 * 매개변수 : 제거할 뜻의 번호 => int num
	 * 리턴타입 : 없음 => void
	 * 메서드명 : removeMeaning
	 */
	public void removeMeaning(int num) {
		if(num > meaningCount || num < 1) { //지울 번호가 입력받은 뜻 수 보다 크면 안된다.
			System.out.println("I can't work.");
			return; // 빠져나가기
		}
		// 잘못 입력된 뜻을 없앴을 때 뒤에 있는 뜻을 앞으로 당겨오는 것
		//num-1번지부터 하나씩 당겨와서 덮어쓰기함.
		for(int i = num-1; i < meaningCount-1; i++) {
			meaning[i] = meaning[i+1];
		}
		//마지막에 쓸모없는 데이터를 지움
		meaning[meaningCount-1] = null;
		//제거 됐으면 뜻 개수를 하나 줄임
		meaningCount--; // 뜻이 하나 빠짐
	}
	
	/** 수정할 뜻의 번지와 수정할 뜨싱 주어지면 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번호, 수정할 뜻 => int meaningNum, String meaning
	 * 리턴타입 : 수정여부 =>boolean
	 * 메서드명 : updateMeaning
	 * 
	 * @param meaningNum
	 * @param meaning2
	 * @return
	 */
	
	public boolean updateMeaning(int meaningNum, String meaning) {
		//수정할 뜻의 번호가 잘못되 경우
		if(meaningNum > meaningCount || meaningNum <= 0) { // 0번지도 포함
			return false;
		}
		// meaningNum는 1부터이고 번지는 0부터이기 떄문에 빼기 1을 한다.
		this.meaning[meaningNum-1] = meaning;
		return true; //수정이 완료 되었기 때문에 return true
	}
	// getter
	public String getTitle() {
		return title;
	}
	// setter
	public void setTitle(String title) {
		this.title = title;
	}
		
	
}
















