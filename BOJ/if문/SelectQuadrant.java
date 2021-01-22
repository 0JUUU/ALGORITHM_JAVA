package com.youngju.useif;

import java.util.Scanner;

/** BOJ 14681 사분면 고르기
 *  각각의 사분면 케이스별로 if문을 이용하여 입력된 x좌표, y좌표가 위치한 사분면 출력 
 * */
public class SelectQuadrant {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		if(x > 0) {
			if(y > 0) System.out.println("1");
			else System.out.println("4");
		} // x > 0
		else {
			if(y > 0) System.out.println("2");
			else System.out.println("3");
		}	// x < 0
	}	// main
}
