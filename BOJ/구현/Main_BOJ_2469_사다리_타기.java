import java.util.*;
import java.io.*;

/**
 * BOJ 2469 사다리 타기
 * 2021.10.19
 * : index 차이가 1보다 크면 바로 탈락이란 걸 명심해...
 * @author 0JUUU
 *
 */
public class Main_BOJ_2469_사다리_타기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		String finalOrder = br.readLine();
		char[][] ladders = new char[n][k-1];
		int questionLine = -1;
		for(int i = 0; i<n; i++) {
			ladders[i] = br.readLine().toCharArray();
			if(ladders[i][0] == '?') questionLine = i; 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<k; i++) {
			int index = i;
			int finalIndex = -1;
			char nowChar = (char) ('A' + i);
			for(int j = 0; j<k; j++) {
				if(finalOrder.charAt(j) == nowChar) {
					finalIndex = j;
					break;
				}
			}
			
			// 층별로 (위에서)
			for(int j = 0; j<questionLine; j++) {
				if(index == 0) {
					if(ladders[j][index] == '-') {
						index += 1;
					}
				} else if(index == k-1) {
					if(ladders[j][index-1] == '-') {
						index -= 1;
					}
				} else {
					if(ladders[j][index-1] == '-') {
						index -= 1;
					} else if(ladders[j][index] == '-') {
						index += 1;
					}
				}
			}
			
			// 층별로 (아래에서)
			for(int j = n-1; j > questionLine; j--) {
				if(finalIndex == 0) {
					if(ladders[j][finalIndex] == '-') {
						finalIndex += 1;
					}
				} else if(finalIndex == k-1) {
					if(ladders[j][finalIndex-1] == '-') {
						finalIndex -= 1;
					}
				} else {
					if(ladders[j][finalIndex-1] == '-') {
						finalIndex -= 1;
					} else if(ladders[j][finalIndex] == '-') {
						finalIndex += 1;
					}
				}
			}
			//System.out.println("현재 글자 >> "+ nowChar + " / 위 index : " + index + ", 아래 index " + finalIndex);
			if(Math.abs(index - finalIndex) > 1) {
				break;
			}
			if(index == finalIndex) {
				if(index == 0) {
					ladders[questionLine][index] = '*';
				} else if(index == k-1) {
					ladders[questionLine][index-1] = '*';
				} else {
					ladders[questionLine][index] = '*';
					ladders[questionLine][index-1] = '*';
				}
			} else {
				if(index == 0 || finalIndex == 0) {
					ladders[questionLine][0] = '-';
					ladders[questionLine][1] = '*';
				} else if(index == k-1 || finalIndex == k-1) {
					ladders[questionLine][k-2] = '-';
					ladders[questionLine][k-3] = '*';
				} else {
					int small = Math.min(index, finalIndex);
					ladders[questionLine][small] = '-';
					ladders[questionLine][small+1] = '*';
				}
			}
		}
		
		boolean isFail = false;
		for(int i = 0; i<k-1; i++) {
			if(ladders[questionLine][i] == '?') {
				isFail = true; break;
			}
		}
		
		for(int i = 0; i<k-1; i++) {
			if(isFail) ladders[questionLine][i] = 'x';
//			if(ladders[questionLine][i] == '?') ladders[questionLine][i] = 'x';
			sb.append(ladders[questionLine][i]);
		}
		System.out.println(sb);
	}
}
