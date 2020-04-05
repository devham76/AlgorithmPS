package org.line;

public class Test2004_2 {

	public static void main(String[] args) {
		String[] ss = {"24553", "24553", "24553", "24553"};
		String a = "24551";
		solution(a, ss);
	}

	public static int solution(String answer_sheet, String[] sheets) {
		int answer = 0;
		String[] newSheets = new String[sheets.length];
		for (int i = 0; i < sheets.length; i++) {
			StringBuilder sb = new StringBuilder();
			String sheet = sheets[i];
			
			for(int j=0; j<answer_sheet.length(); j++) {
				if(answer_sheet.charAt(j) != sheet.charAt(j)) {
					sb.append(sheet.charAt(j));
				}
				else
					sb.append(0);
			}
			newSheets[i] = new String(sb);
		}
	
		for (int i = 0; i < newSheets.length-1; i++) {
			String str1 = newSheets[i];
			for(int j=i+1; j<newSheets.length; j++) {
				String str2 = newSheets[j];	
				int cnt = 0;
				int length = 0;
				int maxLength = 0;
				for(int k=0; k<str1.length();k++) {
					
					if(str1.charAt(k) == '0' || str1.charAt(k) != str2.charAt(k)) {
						maxLength = Math.max(length, maxLength);
						length = 0;
						continue;
					}
					
					if(str1.charAt(k) == str2.charAt(k)) {
						System.out.print(str1.charAt(k)+" ");
						cnt++;
						length++;
						
					}
				}
				maxLength = Math.max(length, maxLength);
				answer = Math.max(answer , cnt + (maxLength * maxLength));
				System.out.println();
				System.out.println("str1="+str1+" str2="+str2+" cnt="+cnt+" maxLength="+maxLength);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
