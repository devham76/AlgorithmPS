package ObectPart;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate d1 = new MyDate(1,1);
		MyDate d2 = new MyDate(1,1);
		
		System.out.println(d1.equals(d2));
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
	}

}
class MyDate {
	int month, day;
	MyDate(int month, int day){
		this.month = month;
		this.day = day;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate md = (MyDate)obj;	//다운캐스팅
			return ( this.month == md.month && this.day == md.day);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}