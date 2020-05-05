package org.programmers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class kakao_17683 {

	public static void main(String[] args) {
		String[] mu = { "12:00,12:14,HELLO,A#B#C#", "13:00,13:05,WORLD,CA#B#" };
		String m = "A#B#C";
		solution(m, mu);
	}

	public static String solution(String m, String[] musicinfos) {

		String answer = "";
		int maxTime = 0;
		for (int i = 0; i < musicinfos.length; i++) {
			String[] arr = musicinfos[i].split(",");
			String start = arr[0];
			String end = arr[1];
			String title = arr[2];
			String melody = arr[3];

			int time = get_time_diff(start, end);
			String wholeMelody = get_whole_melody(melody, time);
			if (check(wholeMelody, m) == true) {
				System.out.println(title);
				if(maxTime < time) {
					answer = title;
					maxTime = time;
				}
				
			}
		}
		if (answer.length() == 0)
			answer = "(None)";
		System.out.println("answer= "+answer);
		return answer;
	}

	private static boolean check(String wholeMelody, String melody) {
		int idx = wholeMelody.indexOf(melody);
		System.out.println("wholeMelody=" + wholeMelody + "\nmelody=" + melody + " idx=" + idx);
		if (idx >= 0) {
			if (melody.length() + idx < wholeMelody.length()) {
				System.out.println(melody.charAt(melody.length() - 1));
				if (melody.charAt(melody.length() - 1) != '#' && wholeMelody.charAt(melody.length() + idx) == '#')
					return false;
			}

			return true;
		}

		return false;
	}

	private static String get_whole_melody(String melody, int time) {
		StringBuffer sb = new StringBuffer();
		int idx = 0;
		for (int i = 0; i < time; i++) {
			String m = melody.charAt(idx % melody.length()) + "";
			if (melody.charAt((idx + 1) % melody.length()) == '#') {
				m = m + "#";
				idx++;
			}

			sb.append(m);
			idx++;
		}
		return new String(sb);
	}

	private static int get_time_diff(String start, String end) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		// 요청시간을 Date로 parsing 후 time가져오기
		try {
			java.util.Date startDate = dateFormat.parse(start);
			java.util.Date endDate = dateFormat.parse(end);
			int diff = (int) ((endDate.getTime() - startDate.getTime()) / 60000);
			return diff;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
}
