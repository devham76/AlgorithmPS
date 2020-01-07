package InterfacePart;

import java.util.Scanner;

public class SortAlgorithmTest {

	public static void main(String[] args) {
		System.out.println("정렬방식을 선택하세요");
		System.out.println("B : BubbleSort");
		System.out.println("H : HeapSort");
		System.out.println("Q : QuickSort");
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		Sort sort = null;
		
		switch(choice) {
		case "Q" : sort = new QuickSort();
		}
		
		sort.description();
	}

}


