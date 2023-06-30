package day22.practice2.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneBook{
	//전화번호 정보(리스트를 관리)
	private List<PhoneNumber> list = new ArrayList<>();
	
	//전화번호 추가
	public boolean insertPhone(String name, String number ) {
		//이름과 전화번호를 이용하여 전화번호 객체를 생성하고
		PhoneNumber pn = new PhoneNumber(name, number);
		//전화번호가 비어 있으면 => 전화번호 패턴에 맞지 않으면 저장 X
		if(pn.getNumber().length() == 0) {
			return false;
		}
		//전화번호가 패턴에 맞으면 전화번호부에 번호를 추가한다.
		list.add(pn);
		return true;
	}
	//전화번호 수정 : 이름
	public boolean updateName(String name, String updateName) {
		//name과 일치하는 전화번호를 찾아야함
		//전화번호부에 수정할 이름이 해당하는 전화번호가 어디에 있는지 확인
		int index = list.indexOf(new PhoneNumber(name,""));
		//없으면 수정이 안됨 => 메서드를 종료
		if(index == -1 /*없으면*/) {
			return false; //업데이트 실패
		}
		//찾은 전화번호의 이름을 수정
		// 전화번호부에서 이름과 일치하는 전화번호를 가져오고
		PhoneNumber pn = list.get(index); //인데스 번지에 있는 전화번호를 가져와서
		//가져온 전화번호의 이름을 수정
		pn.setName(updateName);
		//위에 두 줄을 한 줄로 쓰면 list.get(index).setName(updateName);이렇게 나타낼수 있다.
		
		//기본자료형은 =을 이용하면 값을 복사하기 때문에 한쪽의 값이 바뀌어도 다른쪽은
		// 바뀌지 않는다.
		/*int num1 = 1;
		int num2 = num1;
		num2 = 10
		*/
		
		// 참조변수는 =을 이용하면 주소값을 복사하기 때문에 한쪽의 값이 바뀌면 다른쪽도 바뀐다.(공유)
		//에를 들면 pn1에 저장된 주소가 0x1000이라면
		/*PhoneNumber pn1 = new PhoneNumber("a", "010-1234-5678");
		//pn1에 저장된 주소 : 0x1000, pn2에 저장된 주소 : 0x1000
		PhoneNumber pn2 = pn1;
		//0x1000번지에 있는 객체의 name을 Lim으로 수정
		pn2.setName("Lim");
		*/
		return true;
	}
	//전화번호 수정 : 번호
	public boolean updateNumber(String name, String number) {
		//name과 일치하는 전화번호부를 찾는다.
		int index = list.indexOf(new PhoneNumber(name, number));
		//일치하는 전화번호부가 없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//왜 객체를 생성하나? => number가 전화번호 패턴이 맞는지 확인하기 위해서
		//전화번호 패턴이 맞으면 전화번호 객체를 생성 했을 때 전화번호가 있고,
		//패턴에 맞지 않으면 빈 문자열이 있기 때문이다.
		//일치하는게 있으면 name과 number를 이용하여 전화번호 객체를 생성해야 했지만
		//더 쉽게 하기 위해서는 phoneNumber에 있는 checkNumber의 private을 public static으로 바꿔 줌
		//일치하는게 있으면 name과 number를 이용하여 전화번호 객체를 생성하는 대신 checkNumber를 이용
		//number가 전화번호 패턴이면 전화번호를 수정.
		if(!PhoneNumber.checkNumber(number)) { //아니면(!) false로 출력
			return false;
		}
		list.get(index).setNumber(number);
		return true;
	}
	//전화번호 수정 : 이름, 번호
	public boolean update(String name, String updateName, String number) {
		//두 번 써야 해서 pn으로 밖에 정의 했음
		PhoneNumber pn = new PhoneNumber(name, number);
		//name을 이용하여 전화번호부 검색
		int index = list.indexOf(pn);
		//없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//number가 전화번호 패턴에 안맞으면 실패
		if(!PhoneNumber.checkNumber(number)) {//일치하지 않으면 false로 출력
			return false;
		}
		//맞으면 기존에 있는 전화번호를 삭제하고
		list.remove(index);
		//updateNmae과 number를 이용하여 전화번호 객체를 생성한 후 추가
		pn.setName(updateName);
		list.add(pn);
		return true;
	}
	//전화번호 삭제
	public boolean delete(String name) {
		//name으로  PhoneNumber 객체를 생성 후 삭제 요청을 하면 더 쉽게 가능
		return list.remove(new PhoneNumber(name, ""));
	}
	//전화번호 출력
	public void print(Predicate <PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
}