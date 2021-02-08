import java.util.*;
import java.io.*;
/**
 * SWEA 5215. 햄버거 다이어트
 * 2021.02.08
 * : 1. 강의 시간에 배운 재귀로 부분집합을 구하는 방식 적용 
 * @author 0JUUU
 *
 */
public class Solution_D3_5215_햄버거_다이어트 {
	static int[][] ingredient;
	static int score, N, L;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			score = 0; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredient = new int[N][2];
			isSelected = new boolean[N];
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			
			generateSubSet(0);
			sb.append("#"+tc+" "+score+"\n");
		}
		System.out.println(sb);
	}
	
	static void generateSubSet(int cnt) {
		int calories = 0;
		if(cnt == N) {
			for(int i = 0; i<N;i++) {
				if(isSelected[i]) calories += ingredient[i][1];
			}
			if(calories <= L) {
				int sum = 0;
				for(int i = 0; i<N;i++) {
					if(isSelected[i]) {
						sum += ingredient[i][0];
					}
				}
				if(sum > score) score = sum;
			}
			return;
		}
		
		isSelected[cnt] = true;		// 선택
		generateSubSet(cnt+1);
		isSelected[cnt] = false;	// 비선택
		generateSubSet(cnt+1);
	}
}
