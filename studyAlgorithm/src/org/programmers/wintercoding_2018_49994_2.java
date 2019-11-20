// ���� , https://www.welcomekakao.com/learn/courses/30/lessons/49994
package org.programmers;

public class wintercoding_2018_49994_2 {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		String dirs2 = "LULLLLLLU";
		String dirs3 = "RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU";
		String dirs4 = "LR";
		solution(dirs2);
	}
	public static int solution(String dirs) {
		int answer = 0;
		String record[] = new String[dirs.length()];
		int beforeX = 0, beforeY = 0;
		for (int i = 0; i < dirs.length(); i++) {
			char command = dirs.charAt(i);
			int nowX = beforeX, nowY = beforeY;

			// ��ɴ�� �����δ�
			switch (command) {

			case 'U' : nowY = beforeY + 1; break;
			case 'D' : nowY = beforeY - 1; break;
			case 'R' : nowX = beforeX + 1; break;
			case 'L' : nowX = beforeX - 1; break;
			}
			//System.out.println("---->"+beforeX +","+ beforeY+"," + nowX +","+ nowY);
			// ������ ������� Ȯ���Ѵ�.
			if (nowX < -5 || nowX > 5 || nowY <-5 || nowY > 5) {
				continue;
			}


			boolean is_exist = false;
			String trace;
			
			if ( beforeX < nowX || beforeY < nowY )
				trace = beforeX +","+ beforeY+"," + nowX +","+ nowY;
			else 
				trace = nowX +","+ nowY +","+ beforeX +","+ beforeY;	
			//System.out.println("i:"+i+", tracce:"+trace);
			beforeX = nowX;
			beforeY = nowY;
			// ������ ������ ������ Ȯ���Ѵ�
			for (int j = 0; j < i; j++) {
				if(record[j] != null) {
					if( record[j].equals(trace) ) {
						is_exist = true; break;
					}
				}
			}
			// ������ ������ ���� �ƴ϶��
			if (is_exist == false) {
				answer++;
				record[i] = trace; 
			}
		}
		System.out.println(answer);
		return answer;
	}
}
