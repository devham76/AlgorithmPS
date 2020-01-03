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

        List<Integer> check = new ArrayList<Integer>(); // ������ ���� ��, �ߺ�����

        for (int a = 0; a < list1.size(); a++) { // ������ ���� ���ϱ�
            String s1 = (String) list1.get(a);
            for (int b = 0; b < list2.size(); b++) {
            	
                String s2 = (String) list2.get(b);
                // s1�� ��ġ�ϴ� s2�� �ְ�, s2�� �ִ°� �������� ���ٸ� �߰��Ѵ� 
                if (s1.equals(s2) && !check.contains(b)) {
                    intersection++;
                    // s1�� ��ġ �ϴ� s2�� ã���� �� ��ġ�� �����ؼ� ���� s1�� �ش� ���� ���ؼ� ������ �� �ٽ� �Է����� �ʵ��� �Ѵ�.
                    check.add(b);
                    // s1�� ��ġ�ϴ� s2�� ã���� �����տ� �־��ְ� ������ ���� s1�� Ȯ���Ѵ�.
                    break;
                }

            }
        }

        // !!!!!!!!!�����....
        int union = list1.size() + list2.size() - intersection; // ������

        if (union == 0 && intersection == 0) {
            return 65536;
        }

        return (int) (((float) intersection / union) * 65536);
    }

    // ���ڿ� s�� ��������
    public List subset(String s) { 

        List<String> list = new ArrayList<String>();
        char[] arr = s.toCharArray();
        int size = arr.length - 1;
        String str;
        int start = 0;
        int end = 1;

        while (end <= size) {
            str = String.valueOf(arr[start]) + String.valueOf(arr[end]);
            boolean isMatch = Pattern.matches("^[a-z]*$", str); // �κ������� ���Ұ� ����θ� �����Ǿ� �ִ��� Ȯ��
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
           
        }
        return list;
    }

}
