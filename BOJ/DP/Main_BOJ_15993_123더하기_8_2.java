import java.util.*;
import java.io.*;

/**
 * BOJ 15993 1,2,3 더하기 8
 * 2021.09.22
 * 홀수와 짝수를 한 수에 대해 2차원배열로 두고 계산
 * @author 0JUUU
 *
 */

public class Main_BOJ_15993_123더하기_8_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		final int Mod = 1000000009;
		long[][] dp = new long[100001][2];	// 0 : 홀수, 1 : 짝수
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;
		for(int i = 4; i<= 100000; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % Mod;
			dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % Mod;
		}
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][0] + " " + dp[n][1] + "\n"); 
		}
		System.out.println(sb);
	}
}
