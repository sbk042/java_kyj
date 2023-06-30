package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputStreamEX2 {

	public static void main(String[] args) {
		// 정수를 1부터 10까지 파일에 저장하는 코드를 작성하세요.
		// 파일명은 output1.txt 입니다.쓴다.
		
		// 파일을 가져오는 예제 -> FileOutputStream
		try(FileInputStream fis = new FileInputStream("output1.txt")){
			int data;
			do {
				data = fis.read();
				if(data == -1) {
					break;
				}
				System.out.print(data);
			}while(true);
			System.out.println();
			System.out.println("File reader success!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(
			FileInputStream fis = new FileInputStream("output2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			System.out.println(ois.readLine());
				for(int i = 1; i<=10; i++) {
					System.out.println(ois.readInt());
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

