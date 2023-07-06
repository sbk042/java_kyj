package practice;

public class Identification {

	public static void main(String[] args) {
		//주민등록번호 뒷자리의 맨 첫 번째 숫자는 성별을 나타낸다.
		//주민등록번호에서 성별을 나타내는 숫자를 출력해 보자.
		String pin = "990427-1122334";
		System.out.println(pin.charAt(7));
	}

}
