package day9.classEx;

public class Car {
	/* 
	 * Car			  => 자동차
	 * String name    => 차명
	 * String company => 제조사
	 * int year		  => 연식
	 * int speed	  => 속력
	 * char gear	  => P:주차, R:후진, D:주행, N:중립
	 * boolean power  => 전원
	 */
	
	//멤버 변수(필드)
	private String name;	//차명
	private String company; //제조사
	private int year;		//연식
	private int speed;		//속력
	private char gear;		//P:주차, R:후진, D:주행, N:중립
	private boolean power;  //전원
	
	//생성자 (초기화)
	public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'P';
	}
	
	//메서드
	/** 자동차 정보를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 = > void
	 * 메서드명 : printInfo
	 */
	//public 리턴타입 메서드명() {
	public void printInfo() {
		System.out.println("VIEW");
		System.out.println("COMPANY : " + company);
		System.out.println("MODEL 	: " + name);
		System.out.println("YEAR 	: " + year);
		System.out.println("POWER 	: " + (power? "ON":"OFF"));
		System.out.println("GEAR 	: " + gear);
		System.out.println("SPEED 	: " + speed);
	}
	/** 속력이 1 증가 / 1 감소 하는 메서드
	 * 매개변수 : 증가할건지 => boolean positive
	 * 리턴타입 : 없음 => void
	 * 메서드명 : speedChange
	 */
	public void speedChange(boolean positive) {
		//전언이 꺼져있으면 종료(속력이 증가 하기 전에 전원이 켜져 있는지 )
		if(!power) { //저원이 꺼져 있으면
			return;
		}
		//기어가 중립 또는 주차중이면 종료
		if(gear == 'N' || gear=='P') {
			return;
		}
		// 속력이 증가하는 경우이면
		if(positive) {
			speed += 1;
		}
		//속력이 감소하는 경우이고 속력이 0보다 크면
		else if (speed > 0){
			speed -= 1;
		}
	}
	/** 자동차 시동을 켜거나 끄는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 = > void
	 * 메서드명 :  turn
	 */
	public void turn() {
		//시동이 꺼져 있으면 켬
		if(!power) {
			power = true;
		}else if(gear == 'P') {
			power = false;
		}
	}

	public void setGear(char _gear) {
		gear = _gear;
	}
	
}
