package day23.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamEx2 {

	public static void main(String[] args) {
		//파일에 문자들을 씀
		try(FileWriter fw = new FileWriter("test.txt")){//쓰기모드 열기
		   // 덮어쓰는 거기 때문에 파일을 만들어서 쓴다 그래서 FileNotFoundException이 뜨지 않음
			for( int i = 0; i<5; i++) {
				fw.write("안녕하세요" + i + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//파일에 쓰여 있는 문자들을 읽어옴
		try(FileReader fr = new FileReader("test.txt")){
			char ch[] = new char[1024];
			int len;
			while((len = fr.read(ch)) != -1) {
				/*
				for(int i = 0; i<len; i++) {
					System.out.print(ch[i]);
				}*/
				System.out.println(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
