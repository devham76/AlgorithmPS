package org.programmers;

import java.util.Arrays;
import java.util.ArrayList;

public class Level_3 {

	public static void main(String[] args) {

		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));

	}

    
    //-- 해당 숫자가 124에 해당하는지 확인한다.
    public static int is_124(int num) {
        int x,y;
        do {
            x = num % 10;
            if ( x != 1 && x !=2 && x !=4) {
            	return -1;
            }
            num = num / 10;
        } while (num > 0);
        
       return 1;
    }
  public static String solution(int n) {
      String answer = "";
      int num       = 1;
   
      ArrayList<Integer> allowedNums = new ArrayList<>();
      while (allowedNums.size() != n) {
    	
            if (is_124(num) == 1) { 
                allowedNums.add(num);
            }
            num++;
            if (num > 100) break;
      }

      answer = Integer.toString(allowedNums.get(n-1));      

      return answer;
  }
}