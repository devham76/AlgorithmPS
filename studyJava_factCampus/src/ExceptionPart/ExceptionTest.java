package ExceptionPart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			
			System.out.println(e);
			//return;
		} finally {
			// 예외 여부에 상관없이 실행된다
			try {
				fis.close();
				System.out.println("finally");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("end");
		
		
		try(FileInputStream fis2 =  new FileInputStream("a3.txt")) {
			
		} catch (FileNotFoundException e) {
			System.out.println(e+" 파일이 없음");
		} catch (IOException e) {
			System.out.println(e);
		} 
		
	}

}
