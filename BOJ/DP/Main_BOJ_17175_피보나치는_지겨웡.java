import java.io.*;

/**
 * BOJ 17175 피보나치는 지겨웡
 * 2021.11.10
 * : DP
 * @author 0JUUU
 *
 */
public class Main_BOJ_17175_피보나치는_지겨웡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[51];
		dp[0] = 1; dp[1] = 1;
		for(int i = 2; i<= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1] + 1) % 1000000007;
		}
		
		System.out.println(dp[n]);
	}
}
