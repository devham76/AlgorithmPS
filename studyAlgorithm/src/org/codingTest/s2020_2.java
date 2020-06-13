package org.codingTest;

import java.util.Scanner;
import java.util.regex.Pattern;

public class s2020_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String pw1 = sc.next();
		String pw2 = sc.next();
				
		String idExp = "[a-z0-9]{3,20}$";
		String pwdExp = "[a-zA-Z0-9!@#$]{8,20}$";
		Pattern patteren1 = Pattern.compile("[!@#$]");
		Pattern patteren2 = Pattern.compile("[a-zA-Z]");
		Pattern patteren3 = Pattern.compile("[0-9]");
		
		boolean idchk = id.matches(idExp);
		boolean pwchk4 = pw1.matches(pwdExp);
		
		if(!idchk || !pwchk4 || !pw1.equals(pw2)) {
			System.out.println("fail");
			return;
		}
		
		boolean pwchk1 = patteren1.matcher(pw1).find();
		boolean pwchk2 = patteren2.matcher(pw1).find();
		boolean pwchk3 = patteren3.matcher(pw1).find();
		if(!pwchk1 || !pwchk2 || !pwchk3){
			System.out.println("fail");
			return;
		}
		System.out.println("pass");

	}

}
