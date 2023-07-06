package day27.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOStreamEx {

	public static void main(String[] args) {
		// 문자 단위로 읽어오는 예제
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			while(fr.read(buffer) != -1 ) {
				System.out.print(buffer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		} catch (IOException e) {
			System.out.println("Exception!");
		}
		//문자 단위로 쓰는 예제
		//FileWriter생성자(파일명, 이어쓰기 여부) : 이어쓰기 여부가 true이면 이어서 작성된다.
		//FileWriter생성자(파일명) : 이어쓰기 여부가 없으면 false로 설정되어져 이어서 작성되지 않는다.
		try(FileWriter fw = new FileWriter("file.txt", true)){
			String str = "Hello world!\n";
			fw.write(str); //문자열을 넣으면 문자열이 출력되고 상수를 넣으면 상수가 출력된다.
			String str2 = "Hi. Java!\n";
			fw.write(str2);
			
		} catch (IOException e) {
			System.out.println("Exception!");
		}
	}
}
