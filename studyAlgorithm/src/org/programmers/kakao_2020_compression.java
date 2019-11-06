package org.programmers;

public class kakao_2020_compression {

	public static void main(String[] args) {
		String[] s = {"aabbaccc","ababcdcdababcdcd", "xababcdcdababcdcd","ababa"};
		String[] s2 = {"ababcdcdababcdcd"};
		for (String e:s)
			solution(e);
	//7, 9 , 17
	}
    public static int solution(String s) {
        int min = s.length();
        
        for (int i=1; i<=s.length()/2; i++) {
        	int cnt = 1;
        	String newS = "";
        	String str1 = "";
        	String str2 = "";
        	
        	for (int j=0; j<s.length(); j+=i) {

        		// 자르려는 문자열이 제공된 문자열 범위를 넘는다면 stop
        		if ((j+ 2*i) > s.length()) {
        			newS = (cnt == 1) ? newS + str1 :  newS +cnt+ str1;
        			cnt = 1;
        			str2 = s.substring(j+i);
        			break;
        		}
        		
        		str1 = s.substring(j, j+i);
        		str2 = s.substring(j+i, j + 2*i);
 
        		if(str1.equals(str2))
        			cnt += 1;
        		else {
        			newS = (cnt == 1) ? newS + str1 :  newS +cnt+ str1;
        			cnt = 1;
        		}
        		
        	}
        	newS = (cnt == 1) ? newS + str2 :  newS +cnt+ str1;
        	min  = (min > newS.length()) ? newS.length() : min;
        }
        return min;
    }
}
