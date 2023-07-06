package practice;

public class Avg {

	public static void main(String[] args) {
		//for each문을 사용하여 A학급의 평균 점수를 구하세요.
		int [] marks = {70,60,55,75,95,90,80,80,85,100};
		int total = 0;
		for( int mark : marks) {
			total += mark;
		}
		//평균을 구하기 위해 총 점수를 총 학생수로 나눈다.
		float average = (float) total / marks.length;
		System.out.println(average);
	}

}
