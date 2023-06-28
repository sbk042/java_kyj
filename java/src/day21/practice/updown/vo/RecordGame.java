package day21.practice.updown.vo;

import lombok.Data;

@Data
public class RecordGame {

	private String id;
	private int count;
	
	//생성자
	public RecordGame(String id, int count) {
		this.id = id;
		this.count = count;
	}
	
	//print대신
	@Override
	public String toString() {
		return"[" + id + " : " + count + "]";
	}
}
