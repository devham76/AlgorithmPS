package org.programmers;

import java.util.*;
import java.util.regex.*;
public class kakao_2018_17677_newsClustering_another {

	public static void main(String[] args) {
		String s1 = "french";
		String s2 = "FRANCE";
		
		kakao_2018_17677_newsClustering_another k = new kakao_2018_17677_newsClustering_another();
		k.solution(s1, s2);

	}
	
    public int solution(String str1, String str2) {

        List list1 = subset(str1.toLowerCase());
        List list2 = subset(str2.toLowerCase());

        int intersection = 0;

        List<Integer> check = new ArrayList<Integer>(); // 교집합 구할 떄, 중복제거

        for (int a = 0; a < list1.size(); a++) { // 교집합 개수 구하기
            String s1 = (String) list1.get(a);
            for (int b = 0; b < list2.size(); b++) {
            	
                String s2 = (String) list2.get(b);
                // s1과 일치하는 s2가 있고, s2에 있는걸 넣은적이 없다면 추가한다 
                if (s1.equals(s2) && !check.contains(b)) {
                    intersection++;
                    // s1과 일치 하는 s2를 찾으면 그 위치를 저장해서 다음 s1과 해당 값을 비교해서 같을때 또 다시 입력하지 않도록 한다.
                    check.add(b);
                    // s1과 일치하는 s2를 찾으면 교집합에 넣어주고 끝내고 다음 s1을 확인한다.
                    break;
                }

            }
        }

        // !!!!!!!!!왕충격....
        int union = list1.size() + list2.size() - intersection; // 합집합

        if (union == 0 && intersection == 0) {
            return 65536;
        }

        return (int) (((float) intersection / union) * 65536);
    }

    // 문자열 s의 다중집합
    public List subset(String s) { 

        List<String> list = new ArrayList<String>();
        char[] arr = s.toCharArray();
        int size = arr.length - 1;
        String str;
        int start = 0;
        int end = 1;

        while (end <= size) {
            str = String.valueOf(arr[start]) + String.valueOf(arr[end]);
            boolean isMatch = Pattern.matches("^[a-z]*$", str); // 부분집합의 원소가 영어로만 구성되어 있는지 확인
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
           
        }
        return list;
    }

}
