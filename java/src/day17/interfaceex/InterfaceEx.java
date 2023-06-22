package day17.interfaceex;

public class InterfaceEx {
	//인터페이스의 역할 : 인터페이스를 구현한 클래스가 어떤 기능의 메서드를 제공하는지 명시
	// 협업을 할 때 여러 개발자들이 기능 구현을 할 때 
	public static void main(String[] args) {
		//인터페이스를 이용하여 객체를 생성할 수 없음
		// RunInterface run = new RunInterface(); 
		System.out.println(RunInterface.NUM);
		
		// 인터페이스는 객체를 만들 수 없지만
		// 인터페이스를 구현한 구현클래스는 객체를 만들 수 있다.
		Run run = new Run();
		run.run();
		run.load();
		
		//구현클래스로 생성한 객체를 RunInterface가 관리 할 수 있다.
		RunInterface runInterface = new Run();
		runInterface.run();
		//RunInterface에는 load가 추상메서드로 존재하지 않기 때문에 에러가 발생
		//runInterface.load();
		//아래 코드는 Run클래스의 객체로 클래스변환이 됐기 때문에 load()메서드를 호출할 수 있음.
		((Run)runInterface).load();
		//run(new ShopManager); //단어장, 판매관리 메서드를 실행해보고 싶다 
		run(new VocabularyNoteController());
	}
	
	/* 인터페이스 매개변수 다향성
	 *  - 매개변수를 인터페이스의 객체로 선언하면,
	 * 	호출할 때 매개변수를 구현 클래스들의 객체들이 올 수 있음.
	 * 		=> 다양한 클래스들의 객체가 올 수 있다.
	 *  - RunInterface의 객체를 매개변수로 하면, RunInterface를 구현한
	 *  	구현 클래스인 ShopManager, VocabularyNoteController의 객체가
	 *  	와서 프로그램을 실행할 수 있다.
	 */

	public static void run(RunInterface program) {
		//프로그램 실행
		program.run();
	}
}

interface RunInterface { //인터페이스는 추상메서드이기 때문에 public abstract를 포함하지 않아도 자동으로 생성된다.
	/* public  final static */ int NUM = 10; //클래스 상수 => 클래스를 이용하여 호출
	//public abstract는 붙여도 되고 붙이지 않아도 상관 없다.
	/*public abstract */void run();// 추상메서드이기 때문에 {}구현부가 없다.
}

interface Stop{
	void stop();
}

//구현 클래스 : 인터페이스를 구현한 클래스
//구현 클래스는 : 인터페이스의 모든 추상 메서드를 반드시 오버라이딩 해야함.
//구현 클래스는 여러 인터페이스를 구현할 수 있다.
class Run implements RunInterface, Stop{

	public void load() {
		System.out.println("loading...");
	}
	
	@Override
	public void run() {
		System.out.println("Program Statr!");
		stop();
	}

	@Override
	public void stop() {
		System.out.println("Program Stop!");
		
	}
	
}