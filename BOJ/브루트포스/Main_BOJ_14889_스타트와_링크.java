import java.util.*;
import java.io.*;

/**
 * BOJ 14889 스타트와 링크
 * 2021.03.17
 * : 조합으로 팀을 가른 후, 2개씩 짝을 지어 계산하였다.
 * @author 0JUUU
 *
 */
public class Main_BOJ_14889_스타트와_링크 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] power;
	static int[] teamStart, teamLink;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		power = new int[N][N];
		teamStart = new int[N/2];
		teamLink = new int[N/2];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		System.out.println(min);
	}
	private static void combination(int cnt, int start) {
		if(cnt == N/2) {
			int count = 0;
			for(int i =0; i<N;i++) {	// 스타트 팀과 링크 팀으로 나눈다.
				boolean isSub = false;
				for(int j = 0; j<N/2;j++) {
					if(teamStart[j] == i) {
						isSub = true;
						break;
					}
				}
				if(!isSub) teamLink[count++] = i;
			}
			calculate();
			return;
		}
		for(int i = start; i<N;i++) {
			teamStart[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void calculate() {
		int sumStart = 0, sumLink = 0;
		for(int i = 0; i < N/2;i++) {
			for(int j = i+1; j<N/2;j++) {
				if(i == j) continue;
				sumStart += power[teamStart[i]][teamStart[j]] +  power[teamStart[j]][teamStart[i]]; 
				sumLink += power[teamLink[i]][teamLink[j]] +  power[teamLink[j]][teamLink[i]]; 
			}
		}
		min = Math.abs(sumLink - sumStart) < min ? Math.abs(sumLink - sumStart) : min;
	}
}
