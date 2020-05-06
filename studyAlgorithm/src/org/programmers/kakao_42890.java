package org.programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class kakao_42890 {

	public static void main(String[] args) {
		String[][] r = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		solution(r);
	}

	public static int solution(String[][] relation) {
		ArrayList<Integer> candidateKey = new ArrayList<>();

		int rowLen = relation.length;
		int colLen = relation[0].length;
		
		for (int set = 1; set < (1 << colLen); set++) {
			// 최소성 검사
			if (!isMinimal(set, candidateKey))
				continue;
			
			// 유일성 검사
			if (isUnique(set, rowLen, colLen, candidateKey, relation)) {
				System.out.println(Integer.toBinaryString(set));
				candidateKey.add(set);
			}
		}
		return candidateKey.size();
	}

	private static boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey,
			String[][] relation) {
		HashSet<String> map = new HashSet<>();

		for (int row = 0; row < rowLen; ++row) {
			String dataByKeySet = "";
			
			// 한 row당 해당 컬럼의 값을 뽑아  dataByKeySet을 만들어준다.
			// ex. set=6 이면 0110, 이므로 th값이 1, 2일때 가능하므로, 
			// relation[0][1]=ryan, relation[0][2]=music ==> dataByKeySet=ryanmusic이 될수있다.
			for(int th=0; th<colLen; ++th) {
				System.out.println("set="+set + " th="+th+ " set & (1<<th)="+ (set & (1<<th)));
				if((set & (1<<th)) != 0) {
					System.out.println("relation["+row+"]["+th+"]="+ relation[row][th]);
					dataByKeySet += relation[row][th];
				}
			}
			System.out.println("dataByKeySet="+dataByKeySet);
			// 모든 경우가 독립적인지 확인한다.
			if(map.contains(dataByKeySet)) return false;
			else map.add(dataByKeySet);
		}

		return true;
	}

	private static boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
		// 이미 후보키로 선정된 조합이 들어있는 경우에 속성이 추가되면
		// 그 속성을 없앴을때 유일성을 만족하므로, 최소성을 만족하지 않는다.
		// 따라서 , 이미 후보키로 선정된 조합에 set이 포함되면 안된다!!
		for (int key : candidateKey) {
			if ((key & set) == key)
				return false;
		}
		return true;
	}

}
