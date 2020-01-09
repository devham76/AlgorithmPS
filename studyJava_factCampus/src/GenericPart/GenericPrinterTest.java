package GenericPart;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();	// Powder Ÿ���� ������ 3d�����͸� �������
		Powder powder = new Powder();	// Ÿ���� �����ߴ�
		powderPrinter.setMaterial(powder);	// ������ Ÿ���� �־���� �Ѵ�
		System.out.println(powderPrinter);
		powderPrinter.doPrinting();
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		Plastic plastic = new Plastic(); // ������
		plasticPrinter.setMaterial(plastic); // 3d�����Ϳ� ��� ����
		//plasticPrinter.setMaterial(powder); �����߻� !! ó���� 3d������ �������� ���� �ٸ���
		System.out.println(plasticPrinter);
		plasticPrinter.doPrinting();
	
		// metrial�� ��ӹ��� �ʾұ� ������ water�� ���� ��� �Ұ���
		//GenericPrinter<Water> waterPrinter = new GenericPrinter<>();		
	}
}
