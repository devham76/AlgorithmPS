package org.programmers;

import java.util.Arrays;

public class summercoding_2018_12981 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		
		int n2 = 5;
		String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int a = Arrays.asList(words).indexOf("tank");
		System.out.println(a);
		solution(n, words);
		solution(n2, words2);
	}
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        
    	char firstchar;
    	char lastchar = words[0].charAt(0);
    	int findLocation = 0;
    	int round = 0; 
    	int person = -1;	// ���ӿ��� �� ��� 
        // ������� ���� round�� �޶�����.
        for ( int i=0; i < (words.length / n); i++ ) {
        	
        	for ( int j=0; j < n; j++ ) {
        		firstchar = words[ n*i+j ].charAt(0);
        		
        		// ���� �ܾ��� ������ ���ĺ��� ����ܾ��� ù��° ���ĺ��� �ٸ���
        		if (firstchar != lastchar) {
        			person =  j+1;
        			round = i+1;
        			break;
        		}
        		
        		// ����ܾ �迭 �տ��� �߰ߵȴٸ� ����
        		findLocation = Arrays.asList(words).indexOf( words[n*i+j] );	// ����ܾ��� ��ġ
        		if ( findLocation != n*i+j ) {
        			person = j+1;
        			round = i+1;
        			break;
        		}
        		
        		lastchar = words[ n*i+j ].charAt( words[n*i+j].length()-1 );
        	}
        	
        	if (person >0)
        		break;
        	
        }
        
        if(person == -1) 
        	person = round = 0;
        answer[0] = person;
        answer[1] = round;
       
        System.out.println("person : "+person+" / round : "+round);

        return answer;
    }
}
