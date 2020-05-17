package org.dataStructure;

import java.util.HashMap;
import java.util.Map;

public class hashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person(20, "hyemi");
		Person p2 = new Person(20, "hyemi");

		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode() + "\n" + p2.hashCode());

		// equals()가 true인 두 Object를 HashMap에 put을 할 때 동일한 Key로 인식하고 싶은 경우
		Map<Person, Integer> map = new HashMap<>();
		map.put(p1, 1);
		map.put(p2, 1);
		System.out.println(map.size());
	}

}

class Person {
	public int age;
	public String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}

		Person p = (Person) obj;
		if (this.age == p.age && this.name == p.name)
			return true;
		else
			return false;
	}

	// hashCode()로 native call을 해서 Memory에서 가진 해쉬 주소값을 출력한다
	@Override
	public int hashCode() {

		final int prime = 31;
		int hashCode = 1;
		hashCode = (prime * hashCode) + ((name == null) ? 0 : name.hashCode());
		hashCode = (prime * hashCode) + age;
		return hashCode;
	}

}