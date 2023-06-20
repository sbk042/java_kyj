package day14.Polymorphism;

import day14.Polymorphism.AirConditional.Radio;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 매개변수의 다향성
		 * 리모컨으로 여러 제품의 전원을 켜는 예제
		 * 제품 : TV, 에어컨, 라디오
		 * 리모턴 클래스, TV 클래스 , 에어컨 클래스, 라디오 클래스가 필요
		 * 
		 */
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		AirConditioner aricon1 = new AirConditioner();
		RemoteControl remocon1 = new RemoteControl();
		remocon1.turnOn(tv1); //tv를 켜는 기능
		remocon1.turnOn(aircon1); // 에어컨을 켜는 기능
		remocon1.turnOn(radio1); // 라디오를 켜는 기능
		
		System.out.println("==============");
		//매개변수의 다향성을 이용
		TV tv2 = new TV1();
		Radio1 radio2 = new Radio1();
		AirConditioner1 aricon2 = new AirConditioner1();
		RemoteControl1 remocon2 = new RemoteControl1();
		
		HomeAppliances appliance = tv2; //업캐스팅
		remocon2.turnOn(appliance); //가전을 켜는 기능
		remocon2.turnOn(tv2); // 가전을 켜는 기능
		remocon2.turnOn(aircon2); // 가전을 켜는 기능
		remocon2.turnOn(radio2); // 가전을 켜는 기능
		
		remocon2.turnOn(tv2); //가전을 켜는 기능
		remocon2.turnOn(aircon2); // 가전을 켜는 기능
		remocon2.turnOn(radio2); // 가전을 켜는 기능
	}

}
class RemoteControl{
	public void turnOn(TV tv) { //전원 키기
		tv.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn( AirConditioner aircon) {
		aircon.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn( Radio radio) {
		radio.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
}

class TV{
	boolean power; //전원을 키고 끄기
	int channel; //채널이 있음
	void TurnOn() {
		power = true;
	}
}

class AirConditioner{
	boolean power;
	double CurrentTemperature; //지금온도
	double desiredTemperature; //희망온도
	void TurnOn() {
		power = true;
}
class Radio{
	boolean power;
	double frequency; //라디오 주파수
	void TurnOn() {
		power = true;
	}
	
}
class HomeAppliances{
	boolean power;
	void turnOn() {
		power =true;
	}
	void turnOff() {
		power = false;
	}
}
class RemoteControl1{
	public void turnOn(TV tv) { //전원 키기
		appliance.TurnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn( AirConditioner aircon) {
		aircon.TurnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn( Radio radio) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
}

class TV1 extends HomeAppliances{
	int channel; //채널이 있음
	}


class AirConditioner1 extends HomeAppliances{
	double CurrentTemperature; //지금온도
	double desiredTemperature; //희망온도
}
class Radio1 extends HomeAppliances{
	double frequency; //라디오 주파수
}
	
