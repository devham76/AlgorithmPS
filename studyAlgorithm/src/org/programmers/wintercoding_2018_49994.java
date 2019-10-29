package org.programmers;

import java.util.Arrays;
//   실패 !! 다시 볼것 !!!
public class wintercoding_2018_49994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String dirs = "ULURRDLLU";
		String dirs2 = "LULLLLLLU";
		String dirs3 = "RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU";
		String dirs4 = "LR";
		solution(dirs4);
	}
    public static int solution(String dirs) {
        int answer = 0;
        
        String[] loc = new String[dirs.length()+1];
        //String[] locProcess = new String[dirs.length()];
        loc[0] = "0,0";
        for ( int i=0; i<dirs.length(); i++ ) {
        	String[] current = loc[i].split(",");	// 현재 좌표
        	int x = Integer.parseInt(current[0]);
        	int y = Integer.parseInt(current[1]);
        	
        	// 한정된 좌표 안에서만 움직인다.
        	boolean isOk = false;
        	switch(dirs.charAt(i)) {
        	case 'U' : if (y < 5) { y++; isOk=true; }break;
        	case 'D' : if (y > -5) { y--; isOk=true; }break;
        	case 'R' : if (x < 5) {x++; isOk=true; }break;
        	case 'L' : if (x > -5 ) {x--; isOk=true; }break;
        	}
        	
        	
        	System.out.println("isOk : "+isOk);
        	int overlap = Arrays.asList(loc).indexOf(  x+","+y );
        	loc[i+1] = x+","+y;
        	
        	System.out.println(loc[i+1] + " / " +overlap);
        	if (isOk == false)
        		continue;
        	
          	if (overlap == -1) 
        		answer++;
          	else {
          			
          		if ((overlap-1 >-1 && !loc[overlap-1].equals(loc[i])) && !loc[overlap+1].equals(loc[i]))
          			answer++;
          	}
        }
        System.out.println("answer : "+answer);
        
        return answer;
    }

}
