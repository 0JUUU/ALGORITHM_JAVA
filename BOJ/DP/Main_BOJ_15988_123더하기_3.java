import java.util.*;
import java.io.*;

/**
 * BOJ 15988 1,2,3 더하기 3
 * 2021.02.28
 * : dp의 값들을 그때 그때 1000000009로 나누어 저장해야함!
 * @author 0JUUU
 *
 */
public class Main_BOJ_15988_123더하기_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] dp = new long[1000001];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i = 4; i<=1000000;i++) {
			dp[i] = dp[i -1]% 1000000009 + dp[i-2]% 1000000009 + dp[i-3]% 1000000009;
		}
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] % 1000000009 + "\n");
		}
		
		System.out.println(sb);
	}
}
