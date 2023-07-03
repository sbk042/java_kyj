package day24.thread;

import lombok.Data;

public class User extends Thread {
	private Passbook pb; //통장
	private String name; //이름
	public User(String name, Passbook pb) {
		this.name = name;
		this.pb = pb;
	}
	@Override
	public void run() {
		pb.deposite(name, 10000);//만원을 추가
	}
}
@Data
class Passbook {
	private int balance;
	//예금
	//synchronized를 이용하여 한 개의 스레드만 실행할 수 있다.(동기화메소드)
	public synchronized void deposite(String name, int money) {
		this.balance += money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( name + " : " + money);
		System.out.println("balance : " + this.balance);
	}
}