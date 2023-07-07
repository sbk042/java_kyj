package day28.Baseball.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record implements Serializable{
	
	private static final long serialVersionUID = 7160752409743127991L;
	private String name;
	private int count;
	
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
}
