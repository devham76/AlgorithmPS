package ExceptionPart;

public class AutoCloseTest {

	public static void main(String[] args) {
		// try�ȿ� ������ �ڵ����� �����Ŀ� ������ �ݴ´�
		try( AutoCloseObj obj = new AutoCloseObj()){
			
		}catch(Exception e) {
			
		}
	}

}
