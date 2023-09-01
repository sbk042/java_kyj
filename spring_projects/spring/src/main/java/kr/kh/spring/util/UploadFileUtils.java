package kr.kh.spring.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	/***
	 * 파일을 uploadPath에 복사한 후 복사한 파일경로와 이름을 합쳐서 문자열로 반환하는 메서드
	 * 파일을 업로드한 날짜에 맞춰서 년/월/일 폴더가 생성되고 그 안에 업로드를 한다.
	 * @param uploadPath
	 * @param originalFileName
	 * @param fileData
	 * @return
	 * @throws IOException 
	 */
	public static String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {
		
		// 같은 파일명을 가지는 파일을 업로드할 때 덮어쓰기가 되지 않게 처리하는 작업
		UUID uuid = UUID.randomUUID();
		String savedFileName = uuid.toString() + "_" + originalFileName; //8-4-4-4-12_파일명
		
		// 한 폴더에 파일이 올리지 않게 날짜별로 업로드 파일을 관리
		// 2023/09/01 이런식으로 폴더가 만들어지게 만들거임
		String savedPath = calcPath(uploadPath); // 업로드 날짜를 기준으로 년/월/일 폴더가 없으면 생성하고 생성된 경로를 반환한다.
		
		// 파일을 복사
		// 먼저 빈 파일을 생성해준다.
		File target = new File(uploadPath + savedPath, savedFileName);
		// 실제 파일을 우리가 만들어준 빈 파일 (target)에 복사해준다.
		FileCopyUtils.copy(fileData, target);
		return uploadFileName(savedPath, savedFileName);
	}
	private static String uploadFileName(String savedPath, String savedFileName) {
		String fileName = savedPath + File.separator + savedFileName;
		return fileName.replace(File.separator, "/"); // 문자열, 문자열을 넣어야 replace가 동작 함으로 ""를 사용함
	}
	/***
	 * uploadPath에 기준 날짜(ex.오늘 날짜)에 맞는 년/월/일 폴더가 없으면 생성하고, 폴더의 경로를 반환하는 메서드
	 * @param uploadPath 년/월/일 폴더를 만들 부모 폴더
	 * @return 기준 날짜의 년/월/일 폴더 경로
	 */
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance(); // 현재 날짜를 달력 형태로 받는다.
		// \\2023
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		// 0부터 시작하므로 +1을 해주고 9월이 아닌 09로 나타내기 위해 DecimalFormat을 이용해 빈 자리를 0으로 넣어주는 작업을 해준다.
		// \\2023\\09 <= 이렇게 나타남
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1); 
		// \\2023\\09\\01 <=이렇게 나타남
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		// 폴더를 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	// 위에 있는 makeDir폴더 메서드 만들기
	private static void makeDir(String uploadPath, String...paths) {
		// datePath가 이미 존재하면 이미 폴더가 있는 경우이므로 폴더를 더 만들 필요가 없다.
		if(new File(uploadPath + paths[paths.length-1]).exists()){ // paths.length-1 = datePath를 가리킴
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) { // 존재하지 않으면
				dir.mkdir(); // 폴더를 만들어 준다.
			}
		}
	}
	public static void deleteFile(String uploadPath, String fi_name) {
		File file = new File(uploadPath+fi_name);
		if(file.exists()) { // 파일이 존재하면 삭제하기
			file.delete();
		}
	}
}