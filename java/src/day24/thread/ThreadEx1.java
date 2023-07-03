package day24.thread;

public class ThreadEx1 {

	public static void main(String[] args) {
		ChildThread1 chTread = new ChildThread1();
		chTread.start();
		
		for(int i = 0; i<10; i++) {
			System.out.println("Work1");
		}
		/*
		for( int i  = 0; i<10; i++) {
			System.out.println("Work2");
		}
		*/
		//싱글 쓰레드는 앞에 Wokr1이 10번이 끝나야 다음으로 넘어간다.
	
	}
}

class ChildThread1 extends Thread{
	@Override
	public void run() {
		for( int i  = 0; i<10; i++) {
			System.out.println("Work2");
		}
	}
}