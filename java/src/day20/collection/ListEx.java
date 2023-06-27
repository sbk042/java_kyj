package day20.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(); //숫자를 저장하는 리스트 생성
		// 반복문을 이용하여1부터 5까지 차례대로 추가
		for(int i  = 1; i<=5; i++) {
			list.add(i); //정수 i가 박싱으로 Integer 클래스의 객체가 된 후 list에 추가가된다
		}
		//1을 더 추가 하겠다.
		list.add(1); //1을 list에 추가하겠다.
		System.out.println(list);
		
		//이번에는 1을 제거 하겠다.
		list.remove((Integer)1); //첫번째 만나는 1을 제거한다. (Integer)를 붙여주자
		//첫번째 만나는 1을 제거하고 제거가 되어서 true를 반환
		System.out.println(list); //제거된 걸 확인하기 위해 출력해봄
		// 1번지에 있는 객체를 제거(3을 제거)
		Integer num = list.remove(1); //1번지에 있는 요소를 제거하고 제거한 요소를 반환
		System.out.println(num);
		System.out.println(list);
		System.out.println(list.size());//size-> 저장된 객체 수를 출력. 저장 가능한 최대 객체 수가 아님ㅂ.
		
		
		
		//일반. 리스트는 특정 번지에 접근할 수 있어서 get()을 이용하여 반복문을 활용할 수 있다.
		for(int i = 0; i <list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		//향상된 for문. List와 Set 모두 가능
		for(int tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//Integer
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) { //내 다음에 있는 수가 있는지 없는지 확인,다음 수가 없을 때 까지 반복
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		System.out.println(list.contains(1)); //List에 1이 있는지 없는지 확인할려고 한다.
		System.out.println(list.indexOf(1)); //List에 1이 몇번지에 있는지 확인하려고 한다.
		
		
	}

}








