import java.util.*;
import java.io.*;

/**
 * BOJ 9593. 1, 2, 3 더하기
 * 2021.02.08
 * SSAFY 스터디
 * : dp를 이용한 알고리즘
 * @author 0JUUU
 *
 */
public class Main_BOJ_9593_123_더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i = 4; i<=11;i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int tc = 0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
	}
}
