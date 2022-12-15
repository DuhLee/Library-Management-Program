package lmp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lmp.admin.dao.ExampleDao;
import lmp.admin.vo.BookVO;
import lmp.admin.vo.LocationVO;

public class FileIO {
	
	private static String path = "C:\\javaFullStack_LDH\\repos\\Library_Management_Program\\examplefiles\\BookList.txt";
	private static String imagePath = "";
	
	ExampleDao eDao = new ExampleDao();
	//  /2/1/이지스퍼블리싱/IT전문서/전자책/Do it! 게임 10개 만들며 배우는 파이썬/벤 포터, 쉬무엘 포터/안동현/44915/376/15000/9791163034278/정상 판매중/
	public void textFileReader(String path) {
//		|1|순번|브랜드|분야|도서형태|도서명|저자|역자|발행일|페이지|가격|ISBN|도서상태|
		Pattern pattern = Pattern.compile("(.+)//(\\d+)/([가-힣]+)/(.+)/(.+)/(.+)/(.+)/(.+)/(\\d+)/(\\d+)/(\\d+)/(.+)/(.+)");
		ArrayList<BookVO> list = new ArrayList<>();  
		try {
			File book = new File(path);
			FileReader fin = new FileReader(book);
			BufferedReader in = new BufferedReader(fin);
			// readLine() : BufferedReader 에 추가된 한줄씩 읽는 기능
			String line;
			while ((line = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				String locID = "";
				while (matcher.find()) {
					
					BookVO vo = new BookVO(
										null,
										matcher.group(6),
										matcher.group(7),
										matcher.group(3),
										matcher.group(12).replace("-",""),
										1,
										1,
										null,
										Integer.parseInt(matcher.group(11)),
										new LocationVO("E",null),
										null);
					list.add(vo);
				}
			}
			for (int i = 1; i < list.size(); i++) {				
				eDao.add(list.get(i));
				System.out.println("인서트 중...");
			}
			// 최근에 열었던 순서대로 닫아야 한다
			in.close();
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없거나 쓰기 도중 에러 발생...");
		}
		System.out.println("프로그램 종료.");
		
	}
	
	
	public void imageRead(String imagePath) throws FileNotFoundException, IOException, SQLException {
		
		File image = new File(imagePath);
		eDao.add(image);
	}
	

	public static void main(String[] args) {
		FileIO t = new FileIO();
		try {
			t.imageRead(imagePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
