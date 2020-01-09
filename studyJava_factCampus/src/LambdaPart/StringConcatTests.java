package LambdaPart;

public class StringConcatTests {
	public static void main(String[] args) {
		StringConImpl impl = new StringConImpl();
		impl.makeString("ab", "cd");

		StringConcat concat = (s,v) -> System.out.println("[lambda] : "+s+v); 
		concat.makeString("ab", "cd");
		
		StringConcat concat2 = new StringConcat() {

			@Override
			public void makeString(String s1, String s2) {

				System.out.println(s1+", "+s2);
			}
		};
		concat2.makeString("ab", "cd");
	}
}
