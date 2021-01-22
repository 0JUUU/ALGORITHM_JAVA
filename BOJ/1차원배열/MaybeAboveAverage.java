package com.youngju.array_1;

import java.util.Scanner;

/**
 * BOJ 4344 평균은 넘겠지
 * c언어에서 %를 출력하는 방법 --> %% 
 */
public class MaybeAboveAverage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C= scan.nextInt();
		for(int i = 0;i<C;i++) {
			int N = scan.nextInt();
			double aveg = 0;
			int[] student = new int[N];
			for(int n = 0;n<N;n++) {
				student[n] = scan.nextInt();
				aveg += student[n];
			}
			aveg /= N;
			
			int high = 0;
			for(int n = 0;n<N;n++) {
				if((int)aveg < student[n]) high++;
 			}
			double ans = (double) high / (double) N;
			System.out.printf("%.3f%%\n", ans * (double)100);
		} // 테스트케이스 
	}	// main
}
