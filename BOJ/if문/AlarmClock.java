package com.youngju.useif;

import java.util.Scanner;

/** BOJ 2884 알람 시계
 * :  입력한 시간보다 "45분 일찍 알람 설정하기"
 * 입력한 M(분) 에 따라 케이스를 나눠 출력
 * 입력된 H가 0일 경우를 따로 생각
 * */
public class AlarmClock {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int H = scan.nextInt(); int M = scan.nextInt();
		
		if(M >= 45) {
			System.out.println(H +" " + (M-45));
		}
		else {
			if(H == 0) {
				H = 23;
			}
			else {
				H -= 1;
			}
			M += 15;
			System.out.println(H +" "+ M);
		}
	}
}
