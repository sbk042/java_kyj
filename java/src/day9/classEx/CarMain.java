package day9.classEx;

public class CarMain {

	public static void main(String[] args) {
		/* 현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하세요.
		 * */
		
		//클래스명 객체명(객체명은 내가 짓기 나름) = new 클래스명(매개변수들);
		Car myCar = new Car("The new AVANTE","Hyundai",2023);
		// 현재 내 차 정보를 조회
		myCar.turn(); //시동을 킴
		myCar.setGear('D'); // 기어를 'D'로 논다
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.printInfo();
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.speedChange(true); //속도 3까지 증가
		myCar.printInfo();
		myCar.speedChange(false); //속도 1 감소
		myCar.printInfo();
	}

}
