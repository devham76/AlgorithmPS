package org.dataStructure;

/*
 * hashtable, hashmap 둘다 map인터페이스를 상속받아 구현
 * key, value를 가진다
 * hashtable -> 동기화가능
 * */
public class hashTable {

	public static void main(String[] args) {
		ChaningHashTable ht = new ChaningHashTable(30);
		ht.put("sung", "She is pretty");
		ht.put("jin", "She is model");
		ht.put("hee", "She is angel");
		ht.put("min", "She is cute");

		System.out.println(ht.get("sung"));
		System.out.println(ht.get("jin"));
		System.out.println(ht.get("hee"));
		System.out.println(ht.get("min"));
		System.out.println(ht.get("jae"));
	}

}

class ChaningHashTable {
	// HashNode링크드 리스트를 가진 배열을만든다.
	LinkedList<HashNode>[] data;

	ChaningHashTable(int size) {
		data = new LinkedList[size];
	}

	public void put(String key, String value) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		HashNode hashnode = new HashNode(key, value);
		if (data[index] == null)
			data[index] = new LinkedList();

		data[index].addLast(hashnode);
	}
	
	public String get(String key) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		LinkedList<HashNode> hashnodes = data[index];
		
		for(HashNode node:hashnodes) {
			if(node.key.equals(key)) {
                return node.value;
            }
		}
		return null;
	}

	private int convertToIndex(int hashCode) {
		return hashCode % 26;
	}

	private int getHashCode(String key) {
		int hashCode = key.charAt(0) - 'a'; // 앞글자
		return hashCode;
	}

}

class HashNode {
	String key;
	String value;

	HashNode(String key, String value) {
		this.key = key;
		this.value = value;
	}

}
