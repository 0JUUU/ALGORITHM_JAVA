package com.youngju.array_1;

import java.util.Scanner;
/** BOJ 8958 OX퀴즈
 * */
public class QuixOX {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for(int i = 0;i<T;i++) {
			String s= scan.next();
			
			int[] sum = new int[s.length()];
			int ans = 0;
			for(int l = 0;l<s.length();l++) {
				if(s.charAt(l) == 'O') {
					if(l == 0) sum[l] = 1;
					else sum[l] = sum[l-1] + 1;
				}
				ans += sum[l];
			}
			System.out.println(ans);
		}
	}
}
