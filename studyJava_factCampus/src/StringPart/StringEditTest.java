package StringPart;

public class StringEditTest {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		System.out.println(s1.hashCode());	//96354
		
		s1 = s1.concat(s2);
		System.out.println(s1.hashCode());	//-1424385949 -> s1은 다시 생성된 string을 가르킨다

		StringBuilder buffer = new StringBuilder(s1);
		System.out.println(buffer.hashCode());
		buffer.append("def");
		System.out.println(buffer.hashCode());
	}

}
