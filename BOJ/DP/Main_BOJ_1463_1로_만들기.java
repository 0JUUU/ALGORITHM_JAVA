import java.util.*;
import java.io.*;

/**
 * BOJ 1463. 1로 만들기
 * 2021.02.08
 * SSAFY 스터디 DP
 * : 계산 1, 계산 2, 계산 3의 min값
 * @author 0JUUU
 *
 */
public class Main_BOJ_1463_1로_만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		if(N <= 3) {
			if(N == 1) System.out.println(0);
			else System.out.println(1);
			return;
		}
		dp[1] = 0; dp[2] = 1; dp[3] = 1;
		
		for(int i = 4; i<=N;i++) {
			dp[i] = Integer.MAX_VALUE;
			if(i % 3 == 0) {
				dp[i] = dp[i] > dp[i/3]+1? dp[i/3]+1 : dp[i];
			}
			if(i%2 == 0) {
				dp[i] = dp[i] > dp[i/2] +1 ? dp[i/2] + 1 :dp[i];
			}
			dp[i] = dp[i]>dp[i-1] +1? dp[i-1] +1:dp[i];
		}
		System.out.println(dp[N]);
	}
}
