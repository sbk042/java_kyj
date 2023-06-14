package day11.practice;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 중복되지 않게 3개 만들어서 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * */
		
		int min = 1, max = 9; //랜덤생성 최솟값과 최댓값 입력
		int [] arr = new int[3]; //배열 선언 저장소 3개를 만들겠다.
		
		//방법 1: 9번지까지 있는 배열을 이용
		//장점 : 작업이 단순, 단점 : 저장공간이 필요
		boolean checkArr[] = new boolean[10]; // 배열선언 10개짜리 저장소 생성
		
		for(int i = 0; i < 3;) { //i는 0부터 2까지 0,1,2 =>3개
			int random = (int)(Math.random() * (max - min +1) + min);//랜덤생성만 (저장X)
			//checkArr배열에 random번지에 있는 값이 false이면
			if(!checkArr[random]) {//checkArr에 랜덤번지에 있는게 false이면! (!<=이게 아니라면 이란 뜻)
				//random을 배열에 저장하고 
				arr[i] = random;
				//i를 증가 시키고
				i++;
				//checkArr배열에 ramdom번지에 있는 값을 true로 변경
				checkArr[random] = true;
			}
			
		}	
		for(int i = 0; i<3 ; i++) { //잘 출력되는지 확인
			System.out.println(arr[i]);
		}
		
		//방법2 : 저장된 값들을 비교해서 
		int count = 0; // 현재 저장된 랜덤수 개수
		int i = 0; //반복문에서 사용할 변수
		
		while(count < 3) { //저장이 3개가 될 때 까지 반복
			int random = (int)(Math.random()*(max - min + 1) + min);
			// 이미 저장된 랜덤수들과 하나하나 비교해서 같은게 있는지 확인하여
			// 있으면 반복문 종료
			for(i=0; i <count; i++) { //i가 count보다 작으면 종료
				if(random == arr[i]) {
					break;
				}
			}
			/* 위 반복문에서 break를 만나지 않으면 i는 count일 때 종료하기 때문에
			 * 반복문 종료 후 i는 count와 같다.
			 * 하지만 break를 만나서 중간에 빠져 나오면 i는 count보다 작다 */
			if(i == count) {
				arr[count] = random;
				count++;
				//arr[count++] = random; //위에 두 줄을 한 줄로 줄여 쓸수있음.
			}
		}
		
		
		System.out.println("========================");
		for( i = 0; i<3 ; i++) { //잘 출력되는지 확인
			System.out.println(arr[i]);
		}
		System.out.println("====================");
		printArray(arr); // 밑에 식 잘 되는지 출력
		
		//방법3 : 방법2를 메서드로 변형
		/*count = 0;
		while(count < 3) {
			int random = (int)(Math.random() * (max - min +1) + min);
			//중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) { //중복되지 않으면!
				arr[count] = random;
				count++;
			}
		}
		*/
		createrandomArray(min, max, arr);
		System.out.println("=====================");
		printArray(arr);
	}
	/**for( i = 0; i<3 ; i++) { //잘 출력되는지 확인
	  	System.out.println(arr[i]);
	 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드 (위 코드를 메소드로 변경)
	 * 매개변수 : 배열, 배열의 개수 => int arr[], int size
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	public static void printArray(int arr[]) {
		int i;
		for( i = 0; i<arr.length; i++) { // i가 3인걸 알려줘야됨(매개변수 필요 => int size
			System.out.println(arr[i]); // arr[i]도 알려줘야됨 => 매개변수 필요
		}
		
	}
	/** 정수 num가 배열의 0번지부터 count개 만큼 확인했을 때 중복된 값이 있는지
	 *  없는지 알려주는 메서드
	 *  for(i=0; i <count; i++) { //i가 count보다 작으면 종료
				if(random == arr[i]) {
					break;
				}
			}
			if(i == count) {
				arr[count] = random;
				count++;
				//arr[count++] = random; //위에 두 줄을 한 줄로 줄여 쓸수있음.
			}
	 *  매개변수 : 중복을 확인배열, 비교할 정수 num, 비교할 개수 count
	 *  		=>int arr[], int num, int count
	 *  리턴타입 : 있는지 없는지 => boolean (알려주는 돌려주는 반환하는)
	 *  메서드명 : contains <=포함하고 있는지
	 */
	public static boolean contains(int arr[],int num, int count) {
		for(int i=0; i <count; i++) { 
			// 중복되면 메서드를 종료하면서 중복됐다고 알려줌.
			if(num == arr[i]) {
				return true; //메소드를 빠져나와 중복 된다고 알려줌
			}
		}
		//이 위치까지 왔다는건 return true를 못 만났다는 뜻이고,
		//그 말은 중복되지 않았다는 뜻
		return false;
	}
	/** min에서 max사이의 랜덤한 수를 생성해서 배열에 저장하는 메서드
	 *  매개변수 : 최솟값, 최대값, 배열 = > int min, int max, int arr[]
	 *  리턴타입 : 없음 = > void
	 *  메서드명 : createRandomArray
	 */
	public static void createRandomArray(int min, int max, int arr[]) {
		//배열이 생성되어 있지 않으면(배열이 null이면) 메서드 종료
		if(int arr[] == null) {
		
	}
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
		//ex)1~3 : 3개가 4개짜리 배열에 중복 없이 들어갈 수 없음.
		if(max - min + 1 < arr.length) {
			return;
		}
		int count = 0;
		while(count < 3) { //저장이 3개가 될 때 까지 반복
			int random = (int)(Math.random()*(max - min + 1) + min);
			//중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) {
				
			}
			
	}
	
}
