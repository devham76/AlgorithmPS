package org.programmers;

import java.util.ArrayList;

public class kakao_2020_keyLock {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

		boolean s = solution(key, lock);
	System.out.println(s);
	}
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int[] Nx = {0,1,1};
        int[] Ny = {1,1,0};
        
        ArrayList<Integer> keyX = new ArrayList<>();
        ArrayList<Integer> keyY = new ArrayList<>();
        int lockX = 0, lockY = 0;
        // ÁÂ¹°¼èÀÇ È¨ °³¼ö
        int lockCnt = 0;

        for(int i=0; i<20; i++) {
        	for(int j=0; j<20; j++) {
        		if(key.length > j && key.length > i ) {
        			if( key[i][j] == 1) {
        				keyX.add(i);
        				keyY.add(j);
        			}
        		}
        		if(lock.length > j && lock.length > i) { 
        			if(lock[i][j] == 0) {
        			lockCnt++;
        			lockX = i;
        			lockY = j;
        			}
        		}
        	}
        }
        
        // 
        if (keyX.size() < lockCnt)
        	return false;
        if (lockCnt == 0 )
        	return true;
        
        // ¿­¼è¸¦ ÁÂ¹°¼è ±âÁØ È¨À¸·Î ¿Å±ä´Ù.

        
        for (int i=0; i<keyX.size(); i++) {
            int subX = Math.abs( keyX.get(i) - lockX );
            int subY = Math.abs( keyY.get(i) - lockY );
            int newlockCnt = lockCnt;
            
        	// ÁÂ¹°¼è È¨±îÁö ´Ü¼øÀÌµ¿
            for (int j=0; j<keyX.size(); j++) {
        		keyX.set(j, keyX.get(j)+subX);
        		keyY.set(j, keyY.get(j)+subY);
        		
        		if ( keyX.get(j) < lock.length && keyY.get(j) < lock.length) {
        			if( lock[keyX.get(j)][keyY.get(j)] == 1)
        				break;
        			if( lock[keyX.get(j)][keyY.get(j)] == 0)
        				newlockCnt--;
        		}
        	}
        	
        	// ÁÂ¹°¼è È¨¿¡ ²¸¸ÂÃáÈÄ 90µµ¾¿ È¸ÀüÇØº»´Ù
        	if (newlockCnt != 0) {
        		newlockCnt = lockCnt;
        		for (int k=0; k<3; k++) {
        			
        			for(int j=0; j<keyX.size(); j++) {
        				keyX.set(j, keyX.get(j)+Nx[j]);
        				keyY.set(j, keyY.get(j)+Ny[j]);
        				if ( keyX.get(j) < lock.length && keyY.get(j) < lock.length) {
        					if( lock[keyX.get(j)][keyY.get(j)] == 1)
        						break;
        					if( lock[keyX.get(j)][keyY.get(j)] == 0)
        						newlockCnt--;
        				}
        			}
        			if (newlockCnt == 0) {
        				return true;
        			}
        			
        		}
        	}
        	else {
        		return true;
        	}
        }
        
        return answer;
    }

}
