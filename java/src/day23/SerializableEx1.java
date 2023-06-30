package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SerializableEx1 {

	public static void main(String[] args) {
		Student std1 = new Student(1, 1, 1, "Hong");
		Student std2 = new Student(1, 1, 2, "Lim");

		try(
			FileOutputStream fos = new FileOutputStream("student.txt");
			ObjectOutputStream oss = new ObjectOutputStream(fos)){
				oos.writObject(std1);
				oos.writObject(std2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Student> list = new ArrayList<>();
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream("student.txt"))){
				while(true) {
					Student tmp = (Student)ois.readObject();
					list.add(tmp);
				}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EOFException e) {
			System.out.println("File Read Complete!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
	

}
@Data
@AllArgsConstructor
class Student implements Serializable{

	private static final long serialVersionUID = 230267026519472640L;
	
	private int grade, classNum, num;
	private String name;
}