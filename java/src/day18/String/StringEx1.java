package day18.String;

public class StringEx1 {

	public static void main(String[] args) {
		/* 문자열 관련 메서드*/
		//indexOf : 기준 문자열에서 검색 문자/문자열을 왼쪽부터 검색해서 처음으로 만나는 위치를 반환합니다.
		// lastIndexOf : 기준 문자열에서 검색 문자/문자열을 오른쪽부터 검색해서 처음으로 만나는 위치를 반환합니다.
		// 방향만 반대임
		String str = "Hello world";
		
		//str에서 7번지부터 wo가 있는지 확인. orld에서 wo가 있는지 확인 => 없으면 => -1출력
		//(왼쪽부터)
		int index = str.indexOf("wo",7);
		System.out.println(str + "에서 7번지부터" + "wo" + "가 있나요?" + index);
		
		index = str.indexOf("wo");
		System.out.println(str + "에서 0번지부터" + "wo" + "가 있나요?" + index);
		
		index = str.indexOf("o");
		System.out.println(str + "에서 0번지부터" + "o" + "가 있나요?" + index);
		
		// lastIndexOf : 기준 문자열에서 검색 문자/문자열을 오른쪽부터 검색해서 처음으로 만나는 위치를 반환합니다.
		index = str.lastIndexOf("o");
		System.out.println(str + "에서 0번지부터 " + "o" + "가 오른쪽부터 있나요?" + index);
		
		//index와 contains의 차이점
		//contains : 기준 문자열에서 검색 문자/문자열이 있는지 없는지를 알려줌 리턴타입이 true false로 나타남
		boolean result = str.contains("o");
		System.out.println(str + "에서 0번지부터" + "o" + "가 있나요?" + result);
		// =>true로 출력 
		
		//.length() 총길이 출력
		System.out.println(str + "의 길이는? " + str.length());
		// => 총길이가 출력 11
		
		//replace : 특정 문자나 문자열를 바꿀 때 사용한다. 모두
		//replaceAll : 정규표현식에 맞는 모든 문자/문자열을 수정한다.
		String str2 = str.replace(" ", ","); //공백을 ,로 대처
		System.out.println(str2);
		// => Hello,world로 출력
		
		
		//substring : 부분 문자열 추출
		String str3 = str.substring(6);
		System.out.println(str + "에서 6번지부터 부분 문자열 : " + str3);
		// = > world 출력
		
		//toLowerCase : 소문자로 (전부 소문자로 변경)
		System.out.println(str + " : 소문자 : " + str.toLowerCase());
		//toUpperCase : 대문자로 (전부 대문자로 변경)
		System.out.println(str + " : 대문자 : " + str.toUpperCase());
		
		//tirm : 시작문자(a) 전 공백, 마지막문자(f) 후 공백을 제거, 사이에 있는 공백은 제거하지 못한다.
		// 첫 문자 앞 공백과 마지막 문자 뒤 공백을 제거한 문자열을 반환한다.
		String str4 = "\n\t\tabc\t\tdef\t\n"; // \n은 엔터(다음칸으로 넘어감) \t는 tab키 만큼 띄우기
		System.out.println(str4.trim());
		
		//split : 구분자를 기준으로 문자열을 추출해서 순서대로 배열에 저장
		String str5 = "사과,배,포도";
		String fruits[] = str5.split(",");
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
