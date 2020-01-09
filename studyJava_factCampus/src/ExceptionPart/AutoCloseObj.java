package ExceptionPart;

// 파일 자동 닫아주기
public class AutoCloseObj implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("파일을 close했다");
		
	}

}
