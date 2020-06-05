package StreamLambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamEx {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("hyemi", "haen", "minjun");

		// 일반 방식
		int count = 0;
		for (String name : names) {
			if (name.contains("h"))
				count++;
		}
		System.out.println("count : " + count);

		// 스트링 이용
		count = 0;
		count = (int) names.stream().filter(x -> x.contains("h")).count();
		System.out.println("count (stream) : " + count);

		names.stream().map(n -> n.toUpperCase()).forEach(n -> System.out.println(n));

		List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ages.stream().filter(x -> x > 3).limit(4).forEach(x -> System.out.println(x));

		System.out.println();

		System.out.println(ages.stream().reduce((b, c) -> b + c).get());

		System.out.println(names.stream().filter(el -> {
			System.out.println("call filter...");
			return el.contains("h");
		}).map(el -> {
			System.out.println("call map...");
			return el.toUpperCase();
		}).findFirst());

	}

}
