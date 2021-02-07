import java.util.*;
import java.io.*;

/**
 * BOJ 2309. 일곱 난쟁이
 * 2021.02.05
 * 코딩방범대 브루트포스
 * : 1. 재귀 이용
 * : 2. for문 7개? V 
 * @param args
 */
public class Main_BOJ_2309_일곱_난쟁이2 {
	static int[] dwarf;
	static int[] real;
	static int N;
	static boolean[] isSelected;
	static boolean isFound;
	static int total = 100;
	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		isSelected = new boolean[9];
		real = new int[7];
		N = 7;
		for(int i = 0; i<9;i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		subsetSum(0, 0);
		Arrays.sort(real); 
		for(int i = 0 ;i <7;i++) {
			System.out.println(real[i]);
		}
	}
	
	static void subsetSum(int cnt, int start) {
		int sum = 0;
		if(cnt == N) {
			for(int i = 0; i<7;i++) {
				sum+= real[i];
			}
			
			if(sum == total) {
				isFound = true;
			}
			return;
		}
		for(int i = start ; i<9;i++) {
			if(isFound) break;
			real[cnt] = dwarf[i];
			subsetSum(cnt+1, start+1);
			if(isFound) break;
		}
	}
}
