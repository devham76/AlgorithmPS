package org.programmers;

public class kakao_17681 {

	public static void main(String[] args) {
		int n = 6;
		int[] a1 = {46, 33, 33, 22, 31, 50};
		int[] a2 = {27, 56, 19, 14, 14, 10};
		solution(n,a1,a2);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i=0; i<n; i++) {
			int a1 = arr1[i];
			int a2 = arr2[i];
			int result = a1 | a2;
			String str = Integer.toBinaryString(result);
			if(str.length() < n) {
				int diff = n-str.length();
				for(int k=0; k<diff; k++) {
					str = "0"+str;
				}
			}
			
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<n ; j++) {
				if(str.charAt(j) =='1')
					sb.append("#");
				else
					sb.append(" ");
			}
			answer[i] = new String(sb);
			System.out.println(sb);
		}
		
		return answer;
	}
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        for(int i = 0 ; i < n ; i++) {
            map[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        String[] ans = new String[n];
        int row, index;
        for(int i = 0 ; i < n ;i++) {
            map[i] = String.format("%" + n + "s", map[i]);
            map[i] = map[i].replace('1', '#');
            map[i] = map[i].replace('0', ' ');
        }
        return map;
    }
}
