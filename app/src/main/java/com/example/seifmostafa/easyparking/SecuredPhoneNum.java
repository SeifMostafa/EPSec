package com.example.seifmostafa.easyparking;

import java.lang.String;import java.util.Random;

public class SecuredPhoneNum {
	private String PhoneNum, Secured;

	public SecuredPhoneNum(String phoneNum) {
		super();
		PhoneNum = phoneNum;
	}

	public String getSecured() {
		return Secured;
	}

	public void setSecured() {
		Secured = "";
		Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
		Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
		for (int i = 2; i < PhoneNum.length(); i++) {
			char current = PhoneNum.charAt(i);

			switch (current) {
			case '0':
				Secured += 7;
				break;
			case '1':
				Secured += 6;
				break;
			case '2':
				Secured += 5;
				break;
			case '3':
				Secured += 4;
				break;
			case '4':
				Secured += 3;
				break;
			case '5':
				Secured += 9;
				break;
			case '6':
				Secured += 8;
				break;
			case '7':
				Secured += 2;
				break;
			case '8':
				Secured += 1;
				break;
			case '9':
				Secured += 0;
				break;
			}
			if (i == 4) {
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
			}
			if (i == 7) {
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
			}
			if (i == 8) {
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
			}
			if (i == 9) {
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
				Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
			}

		}
		Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));
		Secured += String.valueOf(0 + new Random().nextInt(9 - 0 + 1));


	}

}
