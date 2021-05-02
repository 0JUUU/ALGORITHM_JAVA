import java.util.*;
import java.io.*;

public class Main_JUNGOL_2078_13일의_금요일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int year = 0;
		int days = 31;
		int day = 5;	// 1900년 1월 13일 : 토요일
		int[] week = new int[7];	// 월 화 수 목 금 토 일
		week[5] = 1;
		while(year != N) {
			// 12월에서 1월로
			if(year != 0) {
				day = (day + (days % 7)) % 7;
				week[day]++;
			}
			// 달에 따라 일 수 결정 ( i : 달)
			for(int i = 1; i<= 11; i++) {
				switch (i) {
				case 1:
				case 3:
				case 5:
				case 7: 
				case 8:
				case 10:
					days = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					days = 30;
					break;
				case 2:
					int now = 1900 + year;
					if(now % 4 == 0 && now % 100 != 0) days = 29;
					else if(now % 400 == 0) days = 29;
					else days = 28;
				default:
					break;
				}
				day = (day + (days % 7)) % 7;
				week[day]++;
			}
			
			year++;
			days = 31;
		}
		for(int i = 0; i<7;i++) {
			sb.append(week[i]+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
