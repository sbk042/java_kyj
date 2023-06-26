package day19.format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {
		int price = 10000; //10,000 이것처럼 표현하고 싶다.
		DecimalFormat df = new DecimalFormat("###,###");//정수 3자리마다 ","를 추가한다.
		//DecimalFormat df = new DecimalFormat("\u00A4###,###");
		String str1 = df.format(price);
		System.out.println(str1);
		
		df = new DecimalFormat("000,000"); // #과 다르게 0은 빈자리를 0으로 채워준다.
		String str2 = df.format(price);
		System.out.println(str2);
		
		
	}

}
