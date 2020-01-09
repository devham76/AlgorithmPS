package ExceptionPart;

public class AutoCloseTest {

	public static void main(String[] args) {
		// try안에 들어오면 자동으로 종료후에 파일을 닫는다
		try( AutoCloseObj obj = new AutoCloseObj()){
			
		}catch(Exception e) {
			
		}
	}

}
