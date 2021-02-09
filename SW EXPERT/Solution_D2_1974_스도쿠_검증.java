package com.ssafy.day0209.after;

import java.util.*;
import java.io.*;

/**
 * SWEA 1974. 스도쿠 검증
 * 2021.02.09
 * 
 * @author 0JUUU
 *
 */
public class Solution_D2_1974_스도쿠_검증 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); 
		for(int tc = 1; tc<=T;tc++) {
			int[][] puzzle = new int[9][9];
			StringTokenizer st;
			for(int i = 0; i<9;i++) {	// 스도쿠 (9x9) 입력
				st  = new StringTokenizer(br.readLine());
				for(int j = 0; j<9;j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 3X3 에서 1~9 겹치면 x
			boolean isAvail = true;
			for(int cntI = 0; cntI<=2;cntI++) {
				for(int cntJ = 0; cntJ<=2;cntJ++) {
					int[] num = new int[10];
					for(int i = 0; i<=2;i++) {
						for(int j = 0;j<=2;j++) {
							int tmp = puzzle[3*cntI+i][3*cntJ+j];
							num[tmp]++;
							if(num[tmp] == 2) {
								isAvail = false; break;
							}
						}
						if(!isAvail) break;
					}
					if(!isAvail) break;
				}
				if(!isAvail) break;
			}
			
			if(isAvail) {	// 내가 위치한 행과 열에 숫자가 중복되는지
				for(int i = 0; i<9;i++) {
					int num[] = new int[10];
					for(int j = 0; j<9;j++) {
						num[puzzle[i][j]] ++;
						if(num[puzzle[i][j]] == 2) {
							isAvail = false; break;
						}
					}
					if(!isAvail) break;
				}
			}
			
			if(isAvail) {	// 내가 위치한 행과 열에 숫자가 중복되는지
				for(int j = 0; j<9;j++) {
					int num[] = new int[10];
					for(int i = 0; i<9;i++) {
						num[puzzle[i][j]] ++;
						if(num[puzzle[i][j]] == 2) {
							isAvail = false; break;
						}
					}
					if(!isAvail) break;
				}
			}
			
			sb.append("#"+tc+" "+(isAvail? 1:0) +"\n");
		}
		System.out.print(sb);
	}
}
