package GenericPart;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();	// Powder 타입을 생성할 3d프린터를 만들었다
		Powder powder = new Powder();	// 타입을 생성했다
		powderPrinter.setMaterial(powder);	// 생성된 타입을 넣어줘야 한다
		System.out.println(powderPrinter);
		powderPrinter.doPrinting();
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		Plastic plastic = new Plastic(); // 재료생성
		plasticPrinter.setMaterial(plastic); // 3d프린터에 재료 대입
		//plasticPrinter.setMaterial(powder); 오류발생 !! 처음에 3d프린터 생성시의 재료와 다르다
		System.out.println(plasticPrinter);
		plasticPrinter.doPrinting();
	
		// metrial을 상속받지 않았기 때문에 water은 재료로 사용 불가능
		//GenericPrinter<Water> waterPrinter = new GenericPrinter<>();		
	}
}
