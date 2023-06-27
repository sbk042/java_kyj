package day20.collection;

import java.util.HashSet;

public class SetEx {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		System.out.println(set); //순서를 보장하지 않는다. 입력순서대로 나열되지 않는다
		
		set.remove(10); //remove 를 이용하여 삭제 가능
		System.out.println(set);
		System.out.println(set.contains(20)); //있는지 없는지 true false로 나타냄
		System.out.println(set.size()); //size를 이용하여 몇개 인지 알 수 있음

	}

}
