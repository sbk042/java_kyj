package day17.interfaceex;

public interface RunInterface {
	int NUM = 10;
	void run();
	default void stop() {
		System.out.println("Program Stop!");
	}
}
