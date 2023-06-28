package day21.set;

import java.util.ArrayList;
import java.util.HashSet;

public class SetRandomEx {

	public static void main(String[] args) {
		/* 배열을 이용해서 1~9사이의 랜덤한 수 3개를 저장(중복되지 않은)*/
		int arr[] = new int[3]; //arr에 3개의 저장소 만들기
		int count = 0; //변수 선언과 동시에 초기화
		int min = 1, max = 9; //최소값 최대값 범위 정하기
		
		while(count < 3 ) { //반복문
			int r = random(min,max);
			int i;
			for( i = 0; i<count; i++) {
				if(arr[i] == r) {
					break;
				}
			}
			//중복된 값이 없으면
			if(i == count) {
				arr[count++] = r;
			}
		}
		System.out.print("[");
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length-1?"":", "));
		}//마지막번지이면 콤마를 찍지 않고 마지막번지가 아니면 콤마를 찍어준다.
		System.out.println("]");
		
		/* List를 이용해서 1~9사이의 랜덤한 수 3개를 저장(중복되지 않은)*/
		ArrayList<Integer> list = new ArrayList<>();
		
		while(list.size() < 3) {
			int r = random(min,max);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		System.out.println(list);
		
		/* Set을 이용해서 1~9사이의 랜덤한 수 3개를 저장(중복되지 않은)*/
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 3) {
			int r =random(min, max);
			set.add(r);
		}
		System.out.println(set);
	}
	//랜덤구문을 똑같이 3번 작성해야하기 때문에 번거로우니 메서드로 만듬
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp; //두 수 바꿔주기
		}
		return (int)(Math.random() * (max - min  + 1)+min);
		
	}
}
