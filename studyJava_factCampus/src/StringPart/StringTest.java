package StringPart;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1==s2); // 메모리의 주소가 다르므로 false
		
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3==s4); // 상수풀에 있는것을 공유하므로 true
	}

}
