package org.baekjoon;

public class Level4_49995 {

	public static void main(String[] args) {
		int[] c = { 1, 1, 5, 7, 2, 9 };
		solution(c);

	}

	public static int solution(int[] cookie) {
		int max = 0;
		for (int startIdx = 0; startIdx < cookie.length - 1; startIdx++) {

			int left = 0;
			for (int sIdx = startIdx; sIdx < cookie.length - 1; sIdx++) {
				left += cookie[sIdx];

				int right = 0;
				int nextIdx = sIdx + 1;
				while (left > right && nextIdx < cookie.length) {
					right += cookie[nextIdx++];
					if (left == right) {
						System.out.println("left=" + left);
						if (max < left)
							max = left;
						break;
					}
				}
			}

		}
		System.out.println(max);
		return max;
	}
}
/*

public static int solution(int[] cookie) {
        int answer = -1;
        int max = 0;
        
        if(cookie.length < 2) return 0;
        if(cookie.length == 2) {
            if(cookie[0] == cookie[1]) return cookie[0];
            else return 0;
        }
        
        for(int i = 0; i < cookie.length - 1; i++) {
            
            int frontSum = cookie[i];
            int indexOfFrontSum = i;
            
            int backSum = cookie[i+1];
            int indexOfBackSum = i+1;
            
            while(true) {
 
                if(frontSum == backSum) max = Math.max(frontSum, max);
                
                if(indexOfFrontSum > 0 && frontSum <= backSum) {
                    indexOfFrontSum--;
                    frontSum += cookie[indexOfFrontSum];
                }
                
                else if(indexOfBackSum < cookie.length - 1 && frontSum >= backSum) {
                    indexOfBackSum++;
                    backSum += cookie[indexOfBackSum];
                }
                
                else break;
            }
            
        }
        
        answer = max;
        return answer;
    }

 */