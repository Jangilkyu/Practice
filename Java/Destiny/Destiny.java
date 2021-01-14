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
		
		// userDate[0] ����
		// userDate[1] ��
		// userDate[2] ��
		// userDate[3] ��
		// userDate[4] ��

		getZodiac(userDate[0]);
		getYear();
		getMonth();
		getDay();
		chkHour(userDate[3], userDate[4]);
		result();

	}// Destiny

	/**
	 * ������ ���ؼ� �츦 ���ϱ� ���� method
	 * 
	 * @param year userDate�迭�� 0��° �޼ҵ忡 �����Ǿ� �ִ� ���� param�� ���� �޾ƿ´�.
	 */
	public void getZodiac(int year) {
		switch (year % 12) {
		case 0:
			zodiac = "������";
			break;
		case 1:
			zodiac = "��";
			break;
		case 2:
			zodiac = "��";
			break;
		case 3:
			zodiac = "����";
			break;
		case 4:
			zodiac = "��";
			break;
		case 5:
			zodiac = "��";
			break;
		case 6:
			zodiac = "��";
			break;
		case 7:
			zodiac = "�䳢";
			break;
		case 8:
			zodiac = "��";
			break;
		case 9:
			zodiac = "��";
			break;
		case 10:
			zodiac = "��";
			break;
		case 11:
			zodiac = "��";
			break;
		}// end switch
	}// getZodiac

	public void init() {
		destinyInfo[0][0] = "��";
		destinyInfo[0][1] = "õ��";
		destinyInfo[1][0] = "��";
		destinyInfo[1][1] = "õ��";
		destinyInfo[2][0] = "��";
		destinyInfo[2][1] = "õ��";
		destinyInfo[3][0] = "�䳢";
		destinyInfo[3][1] = "õ��";
		destinyInfo[4][0] = "��";
		destinyInfo[4][1] = "õ��";
		destinyInfo[5][0] = "��";
		destinyInfo[5][1] = "õ��";
		destinyInfo[6][0] = "��";
		destinyInfo[6][1] = "õ��";
		destinyInfo[7][0] = "��";
		destinyInfo[7][1] = "õ��";
		destinyInfo[8][0] = "������";
		destinyInfo[8][1] = "õ��";
		destinyInfo[9][0] = "��";
		destinyInfo[9][1] = "õ��";
		destinyInfo[10][0] = "��";
		destinyInfo[10][1] = "õ��";
		destinyInfo[11][0] = "����";
		destinyInfo[11][1] = "õ��";
	}// init

	// ============== �ֿ� ��� =====================
	/**
	 * 
	 */
	int monthCycle;
	int dayCycle;

	public void getYear() {

		for (monthCycle = 0; monthCycle < destinyInfo.length; monthCycle++) {
			if (zodiac.equals(destinyInfo[monthCycle][0])) {
//				System.out.println("����: " + sajuInfo[monthCycle][1]);
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
//				System.out.println("����: " + sajuInfo[monthCycle][1]);
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
//			System.out.println("����: " + sajuInfo[dayCycle][1]);
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
			zodiac1 = "������";
			break;
		case 17:
		case 18:
			zodiac1 = "��";
			break;
		case 19:
		case 20:
			zodiac1 = "��";
			break;
		case 21:
		case 22:
			zodiac1 = "����";
			break;
		case 23:
		case 0:
			zodiac1 = "��";
			break;
		case 1:
		case 2:
			zodiac1 = "��";
			break;
		case 3:
		case 4:
			zodiac1 = "��";
			break;
		case 5:
		case 6:
			zodiac1 = "�䳢";
			break;
		case 7:
		case 8:
			zodiac1 = "��";
			break;
		case 9:
		case 10:
			zodiac1 = "��";
			break;
		case 11:
		case 12:
			zodiac1 = "��";
			break;
		case 13:
		case 14:
			zodiac1 = "��";
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
