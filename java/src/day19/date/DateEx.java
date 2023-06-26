package day19.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) throws ParseException {
		
		// 현재 시간을 Data 객체로 생성하는 방법(java.util)
		Date now = new Date();
		System.out.println(now);
		
		//Date 객체를 => 문자열로 바꾼다 >>왜? 보기 편하게 만들기 위해
		//( 년,월,일,시,분,초 로 나타냈다.)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd EE요일 HH:mm:ss");
		String str = format.format(now);
		System.out.println(str);
		
		//문자열을 => Date 객체로 바꾸기
		format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		str = "2023-06-27 18:00:00"; //현재 시간 정보가 문자열로 주어진 경우 
		Date date = format.parse(str);
		System.out.println(date);
		
		
		//Date 객체에서 시간대를 출력하는 예제 (ex : 대한민국 표준시 )
		date = new Date();
		// 원하는 포맷 지정
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzzz");
		
		//시간대 정보 지정. 시스템에서 제공하는 기본값
		ZoneId zoneId = ZoneId.systemDefault();
		
		//Date 객체를 ZonedDateTime으로 변환
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
		
		//시간대 정보를 포함하여 문자열로 변환
		String formattedDateTime = zonedDateTime.format(formatter);
		
		// 결과 출력
		System.out.println(formattedDateTime);
	}

}
