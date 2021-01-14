import java.util.StringTokenizer;

import org.w3c.dom.UserDataHandler;

public class Destiny {

	String a = "";
	int userDate[];
	StringTokenizer stk;
	String zodiac;
	String destinyInfo[][];
	String result[];

	public Destiny() {
		userDate = new int[5];
		destinyInfo = new String[12][2];
		result = new String[4];
		
		a = "2021-07-06T12:00";
		
		init();
		stk = new StringTokenizer(a, "-T:", false);
		
		int idx = 0;
		while (stk.hasMoreTokens()) {
			userDate[idx] = Integer.valueOf(stk.nextToken());
			idx++;
		} // end while

		for(int s : userDate) {
			System.out.println(s);
		}
		
		// userDate[0] 생년
		// userDate[1] 월
		// userDate[2] 일
		// userDate[3] 시
		// userDate[4] 분

		getZodiac(userDate[0]);
		getYear();
		getMonth();
		getDay();
		chkHour(userDate[3], userDate[4]);
		result();

	}// Destiny

	/**
	 * 생년을 통해서 띠를 구하기 위한 method
	 * 
	 * @param year userDate배열에 0번째 메소드에 지정되어 있는 년을 param을 통해 받아온다.
	 */
	public void getZodiac(int year) {
		switch (year % 12) {
		case 0:
			zodiac = "원숭이";
			break;
		case 1:
			zodiac = "닭";
			break;
		case 2:
			zodiac = "개";
			break;
		case 3:
			zodiac = "돼지";
			break;
		case 4:
			zodiac = "쥐";
			break;
		case 5:
			zodiac = "소";
			break;
		case 6:
			zodiac = "범";
			break;
		case 7:
			zodiac = "토끼";
			break;
		case 8:
			zodiac = "용";
			break;
		case 9:
			zodiac = "뱀";
			break;
		case 10:
			zodiac = "말";
			break;
		case 11:
			zodiac = "양";
			break;
		}// end switch
	}// getZodiac

	public void init() {
		destinyInfo[0][0] = "쥐";
		destinyInfo[0][1] = "천귀";
		destinyInfo[1][0] = "소";
		destinyInfo[1][1] = "천액";
		destinyInfo[2][0] = "범";
		destinyInfo[2][1] = "천권";
		destinyInfo[3][0] = "토끼";
		destinyInfo[3][1] = "천파";
		destinyInfo[4][0] = "용";
		destinyInfo[4][1] = "천인";
		destinyInfo[5][0] = "뱀";
		destinyInfo[5][1] = "천문";
		destinyInfo[6][0] = "말";
		destinyInfo[6][1] = "천복";
		destinyInfo[7][0] = "양";
		destinyInfo[7][1] = "천고";
		destinyInfo[8][0] = "원숭이";
		destinyInfo[8][1] = "천역";
		destinyInfo[9][0] = "닭";
		destinyInfo[9][1] = "천간";
		destinyInfo[10][0] = "개";
		destinyInfo[10][1] = "천수";
		destinyInfo[11][0] = "돼지";
		destinyInfo[11][1] = "천명";
	}// init

	// ============== 주요 기능 =====================
	/**
	 * 
	 */
	int monthCycle;
	int dayCycle;

	public void getYear() {

		for (monthCycle = 0; monthCycle < destinyInfo.length; monthCycle++) {
			if (zodiac.equals(destinyInfo[monthCycle][0])) {
//				System.out.println("생년: " + sajuInfo[monthCycle][1]);
				result[0]= destinyInfo[monthCycle][1];
				break;
			}
		} // end for
	}// getYear

	/**
	 * 
	 * 
	 */
	public void getMonth() {
		for (int i = 0; i < userDate[1]; i++) {
			if (monthCycle >= 12) {
				monthCycle = 0;
			} // end if
//				System.out.println("생월: " + sajuInfo[monthCycle][1]);
				result[1]= destinyInfo[monthCycle][1];
			dayCycle = monthCycle++;
		} // end for
	}// getMonth

	int timeCycle = 0;

	public void getDay() {
		for (int i = 0; i < userDate[2]; i++) {
			if (dayCycle >= 12) {
				dayCycle = 0;
			} // end if
//			System.out.println("생일: " + sajuInfo[dayCycle][1]);
			result[2]= destinyInfo[dayCycle][1];
			timeCycle = dayCycle++;
			System.out.println("timecycle" + timeCycle);
		} // end for
	}// getDay

	String zodiac1;

	public void chktime(int month) {
		switch (month) {
		case 15:
		case 16:
			zodiac1 = "원숭이";
			break;
		case 17:
		case 18:
			zodiac1 = "닭";
			break;
		case 19:
		case 20:
			zodiac1 = "개";
			break;
		case 21:
		case 22:
			zodiac1 = "돼지";
			break;
		case 23:
		case 0:
			zodiac1 = "쥐";
			break;
		case 1:
		case 2:
			zodiac1 = "소";
			break;
		case 3:
		case 4:
			zodiac1 = "범";
			break;
		case 5:
		case 6:
			zodiac1 = "토끼";
			break;
		case 7:
		case 8:
			zodiac1 = "용";
			break;
		case 9:
		case 10:
			zodiac1 = "뱀";
			break;
		case 11:
		case 12:
			zodiac1 = "말";
			break;
		case 13:
		case 14:
			zodiac1 = "양";
			break;
		}// end switch
		getTime(zodiac1);
	}// getTime

	public void chkHour(int month, int minute) {
		if (minute > 0) {
			++month;
		}
		chktime(month);
	}// chkHour

	public void getTime(String zodiac) {
		int get = timeCycle;
		System.out.println("get" + get);
		for (int i = 0; i < timeCycle; i++) {
			if (dayCycle >= 12) {
				dayCycle = 0;
			} // end if
				result[3]= destinyInfo[dayCycle][1];
				dayCycle++;
		} // end for
	}// getTime
	
	public void result() {
		for(String r : result) {
			System.out.println(r);
		}//end for
	}//end if

	public static void main(String[] args) {
		Destiny a = new Destiny();

	}// main
}// class
