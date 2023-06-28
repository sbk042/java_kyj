package day21.practice;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(4);
		list.add(8);
		System.out.println(list); //정렬이 안되게 출력된다.(ex.오름차순,내림차순)
		/* 리스트에 있는 sort는 compare메서드를 가진 객체가 필요함*/
		/* 왜? 정렬기준을 compare로 하기 때문이다. compare값이 음수이면 앞으로, 같으면 0,
		 * 양수이면 뒤로 가게 정렬을 해준다.
		 * 객체가 compare 메서드를 반드시 갖게하기 위해 comparator 인터페이스를 구현한
		 * 구현 클래스의 객체만 올 수 있게 지정했다.*/
		//list.sort(new IntegerCompare());
		//Comparator 인터페이스의 익명 클래스를 만들어서 객체를 생성 
		/*
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});*/
		list.sort(null);
		//list.sort((Integer o1, Integer o2)->01-02);
		System.out.println(list);
	}

}
//오름차순으로 정렬
class IntegerCompare implements Comparator<Integer>{

	//@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
	
}