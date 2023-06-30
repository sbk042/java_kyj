package day22.practice2.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

//한 사람의 전화번호
@Data //기터세터 추가
public class PhoneNumber { //멤버변수 만들기
	private String name;
	private String number; //010-1234-5678 문자열로 받아야됨
	
	public PhoneNumber (String name, String number) {
		this.name = name;
		this.number = "";
		if (checkNumber(number)) {
			this.number = number;
		}
		this.number = checkNumber(number)?number:"";
	}
	
	//전화번호가 010-xxxx-xxxx 패턴이 맞는지 확인해주는 메서드
	//외부에서도 객체생성업이 쓸 수 있게 static과 public을 붙여줌
	public static boolean checkNumber(String num) {
		String regex = "^010(-\\d{4}){2}$";//정규표현식 공부하기
		return Pattern.matches(regex, num);//문자열이 정규표현식이 맞는지 확인해주는 pattern.matches활용
		
	}
	
	public void setNumber(String number) { 
		this.number = checkNumber(number)?number:this.number;
	}
	//source -> Generate -> hashcode
	@Override
	public boolean equals(Object obj) { //전화번호 한 개 관리 할 수 있음
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
}
