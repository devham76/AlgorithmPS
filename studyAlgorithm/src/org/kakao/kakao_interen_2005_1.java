package org.kakao;

public class kakao_interen_2005_1 {

	public static void main(String[] args) {
		int[] n = { 0,0,0,0,8,5,0,2,5,8};
		String h = "right";
		solution(n, h);
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		// 0: 왼쪽손 현재 , 1:오른쪽손 현재
		int[] hands = new int[2];
		hands[0] = 10;
		hands[1] = 12;
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			number = number == 0 ? 11 : number;

			if (number == 1 || number == 4 || number == 7) {
				answer += "L";
				hands[0] = number;
				continue;
			} else if (number == 3 || number == 6 || number == 9) {
				answer += "R";
				hands[1] = number;
				continue;
			}

			if (hands[0] == number) {
				answer += "L";
				continue;
			} else if (hands[1] == number) {
				answer += "R";
				continue;
			}

			boolean Lok = (hands[0] % 3 == 1);
			boolean Rok = (hands[1] % 3 == 0);


			int Ldir, Rdir;
			if (Lok == true) {
				if (Math.abs(number - hands[0]) == 1)
					Ldir = 0;
				else {
					Ldir = Math.abs(number - hands[0]) / 3;
					if (number < hands[0])
						Ldir++;
				}
			} else {
				Ldir = (Math.abs(number - hands[0]) / 3) - 1;
			}

			if (Rok == true) {
				if (Math.abs(number - hands[1]) == 1)
					Rdir = 0;
				else {
					Rdir = (Math.abs(number - hands[1]) / 3) ;
					if (number > hands[0])
						Rdir++;
				}
			} else {
				Rdir = (Math.abs(number - hands[1]) / 3) - 1;
			}

			System.out.println("number=" + number + " hands 0=" + hands[0] + " hands 1=" + hands[1] + " ldir=" + Ldir
					+ " RDIR=" + Rdir);

			if (Ldir == Rdir) {
				if (hand.equals("right")) {
					hands[1] = number;
					answer += "R";
				} else if (hand.equals("left")) {
					hands[0] = number;
					answer += "L";
				}

			} else if (Ldir > Rdir) {
				hands[1] = number;
				answer += "R";
			} else if (Ldir < Rdir) {
				hands[0] = number;
				answer += "L";
			}

		}
		System.out.println(answer);
		return answer;
	}
}
