package day24.thread;

public class ThreadE2 {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new ChildThread2());
		thread.start();
		//멀티 스레드 : 메인 스레드 외의 추가적인 스레드를 이용하여 병렬적으로 작업처리
		//실행할 때 마다 +와-가 섞여서 나온다.(반반으로 나올 때도 있음)
		
		for(int i =0; i<10; i++) {
			System.out.println("+");
		}
	}
}

class ChildThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.println("-");
		}
	}
}